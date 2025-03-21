// OverService
package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.factory.MatchFormatDetailsFactory;
import org.example.caseStudies.designCricinfo.models.Innings;
import org.example.caseStudies.designCricinfo.models.Match;
import org.example.caseStudies.designCricinfo.models.Over;
import org.example.caseStudies.designCricinfo.models.Player;
import org.example.caseStudies.designCricinfo.models.dto.over.OverCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.over.OverSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.over.OverUpdateRequest;
import org.example.caseStudies.designCricinfo.models.enums.InningsStatus;
import org.example.caseStudies.designCricinfo.repository.InningsRepository;
import org.example.caseStudies.designCricinfo.repository.MatchRepository;
import org.example.caseStudies.designCricinfo.repository.OverRepository;
import org.example.caseStudies.designCricinfo.repository.PlayerRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class OverService {
    private final Logger logger = Logger.getInstance();
    private final OverRepository overRepository = OverRepository.getInstance();
    private final InningsRepository inningsRepository = InningsRepository.getInstance();
    private final PlayerRepository playerRepository = PlayerRepository.getInstance();
    private final MatchRepository matchRepository = MatchRepository.getInstance();
    private final InningsService inningsService = new InningsService();

    public Over createOver(OverCreateRequest overCreateRequest) {
        logger.info("Creating new over: " + overCreateRequest);

        validateOverCreateRequest(overCreateRequest);

        Innings innings = inningsRepository.getById(overCreateRequest.inningsId);
        if (innings.getInningsStatus() != InningsStatus.IN_PROGRESS) {
            throw new BusinessValidationException("Over can only be created for an in-progress innings");
        }

        Player bowler = playerRepository.getById(overCreateRequest.bowlerId);

        List<Over> existingOvers = overRepository.findByInningsId(innings.getInningsId());
        Match match = matchRepository.getById(innings.getMatchId());

        int allowedOvers = MatchFormatDetailsFactory.getInningsOvers(match);
        if(existingOvers.size() >= allowedOvers)
        {
            throw new IllegalStateException("Cannot create more overs: maximum allowed overs for this innings reached");
        }

        if (!existingOvers.isEmpty()) {
            boolean overExists = existingOvers.stream()
                    .anyMatch(over -> over.getOverNumber() == overCreateRequest.overNumber);

            if (overExists) {
                throw new BusinessValidationException("Over number already exists for this innings");
            }

            if (overCreateRequest.overNumber > 1) {
                boolean previousOverComplete = existingOvers.stream()
                        .filter(over -> over.getOverNumber() == overCreateRequest.overNumber - 1)
                        .allMatch(Over::isCompleted);

                if (!previousOverComplete) {
                    throw new BusinessValidationException("Previous over must be completed first");
                }
            }
        } else if (overCreateRequest.overNumber != 1) {
            throw new BusinessValidationException("First over must have number 1");
        }

        Over over = new Over(overCreateRequest.inningsId, overCreateRequest.overNumber, overCreateRequest.bowlerId);
        over.setBallIds(new ArrayList<>());
        over.setCompleted(false);

        Over savedOver = overRepository.save(over);

        // Add over to innings
        inningsService.addOverToInnings(innings.getInningsId(), savedOver.getOverId());

        logger.info("Successfully created over with ID: " + savedOver.getOverId());
        return savedOver;
    }

    public Over getOverById(String overId) {
        logger.debug("Fetching over with ID: " + overId);
        return overRepository.getById(overId);
    }

    public Over updateOver(String overId, OverUpdateRequest overUpdateRequest) {
        logger.info("Updating over with id: " + overId);
        Over existingOver = overRepository.getById(overId);

        // Validate innings is still in progress
        Innings innings = inningsRepository.getById(existingOver.getInningsId());
        if (innings.getInningsStatus() != InningsStatus.IN_PROGRESS) {
            throw new BusinessValidationException("Cannot update over for a non-in-progress innings");
        }

        // Update completion status if provided
        if (overUpdateRequest.isCompleted != null) {
            // Check if over has 6 balls before marking it as complete
            if (overUpdateRequest.isCompleted && existingOver.getBallIds().size() < 6) {
                throw new BusinessValidationException("Over must have 6 balls before marking as complete");
            }
            existingOver.setCompleted(overUpdateRequest.isCompleted);
        }

        // Update bowler if provided
        if (overUpdateRequest.bowlerId != null) {
            // Cannot change bowler if balls have been bowled
            if (!existingOver.getBallIds().isEmpty()) {
                throw new BusinessValidationException("Cannot change bowler after balls have been bowled");
            }

            // Validate that bowler exists
            playerRepository.getById(overUpdateRequest.bowlerId);
            existingOver.setBowlerId(overUpdateRequest.bowlerId);
        }

        Over updatedOver = overRepository.update(existingOver);
        logger.info("Successfully updated over with ID: " + overId);
        return updatedOver;
    }

    public void deleteOver(String overId) {
        logger.info("Deleting over with id: " + overId);
        Over existingOver = overRepository.getById(overId);

        // Validate innings is still in progress
        Innings innings = inningsRepository.getById(existingOver.getInningsId());
        if (innings.getInningsStatus() != InningsStatus.IN_PROGRESS) {
            throw new BusinessValidationException("Cannot delete over for a non-in-progress innings");
        }

        // Cannot delete if balls have been bowled
        if (!existingOver.getBallIds().isEmpty()) {
            throw new BusinessValidationException("Cannot delete over with existing balls");
        }

        // Remove over from innings
        innings.getOverIds().remove(overId);
        inningsRepository.update(innings);

        overRepository.deleteById(overId);
        logger.info("Successfully deleted over with ID: " + overId);
    }

    public List<Over> findOvers(OverSearchRequest overSearchRequest) {
        logger.debug("Finding overs with filters");
        return overRepository.findAll().stream().filter((over) -> {
            boolean inningsIdFilter = overSearchRequest.inningsId == null ||
                    over.getInningsId().equals(overSearchRequest.inningsId);
            boolean overNumberFilter = overSearchRequest.overNumber == null ||
                    over.getOverNumber() == overSearchRequest.overNumber;
            boolean bowlerIdFilter = overSearchRequest.bowlerId == null ||
                    over.getBowlerId().equals(overSearchRequest.bowlerId);
            boolean completedFilter = overSearchRequest.isCompleted == null ||
                    over.isCompleted() == overSearchRequest.isCompleted;

            return inningsIdFilter && overNumberFilter && bowlerIdFilter && completedFilter;
        }).toList();
    }

    public void addBallToOver(String overId, String ballId) {
        logger.info("Adding ball " + ballId + " to over " + overId);
        Over over = overRepository.getById(overId);

        // Validate over is not completed
        if (over.isCompleted()) {
            throw new BusinessValidationException("Cannot add ball to a completed over");
        }

        // Check if over already has 6 balls
        if (over.getBallIds().size() >= 6) {
            throw new BusinessValidationException("Cannot add more than 6 balls to an over");
        }

        List<String> balls = over.getBallIds();
        balls.add(ballId);
        over.setBallIds(balls);
        overRepository.update(over);
        logger.info("Successfully added ball to over");
    }

    private void validateOverCreateRequest(OverCreateRequest overCreateRequest) {
        validateNotNull(overCreateRequest.inningsId, "Innings ID");
        validateNotNull(overCreateRequest.bowlerId, "Bowler ID");

        if (overCreateRequest.overNumber <= 0) {
            throw new BusinessValidationException("Over number must be positive");
        }
    }

    private void validateNotNull(Object fieldValue, String fieldName) {
        if (fieldValue == null) {
            throw new BusinessValidationException(String.format("%s cannot be empty", fieldName));
        }
    }
}