// InningsService
package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.models.Innings;
import org.example.caseStudies.designCricinfo.models.Match;
import org.example.caseStudies.designCricinfo.models.Team;
import org.example.caseStudies.designCricinfo.models.dto.innings.InningsCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.innings.InningsSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.innings.InningsUpdateRequest;
import org.example.caseStudies.designCricinfo.models.enums.InningsStatus;
import org.example.caseStudies.designCricinfo.models.enums.MatchStatus;
import org.example.caseStudies.designCricinfo.repository.InningsRepository;
import org.example.caseStudies.designCricinfo.repository.MatchRepository;
import org.example.caseStudies.designCricinfo.repository.TeamRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class InningsService {
    private final Logger logger = Logger.getInstance();
    private final InningsRepository inningsRepository = InningsRepository.getInstance();
    private final MatchRepository matchRepository = MatchRepository.getInstance();
    private final TeamRepository teamRepository = TeamRepository.getInstance();

    public Innings createInnings(InningsCreateRequest inningsCreateRequest) {
        logger.info("Creating new innings: " + inningsCreateRequest);

        validateInningsCreateRequest(inningsCreateRequest);

        Match match = matchRepository.getById(inningsCreateRequest.matchId);
        if (match.getMatchStatus() != MatchStatus.LIVE) {
            throw new BusinessValidationException("Innings can only be created for a live match");
        }

        Team battingTeam = teamRepository.getById(inningsCreateRequest.battingTeamId);
        Team bowlingTeam = teamRepository.getById(inningsCreateRequest.bowlingTeamId);

        if (!match.getTeamIds().contains(inningsCreateRequest.battingTeamId) ||
                !match.getTeamIds().contains(inningsCreateRequest.bowlingTeamId)) {
            throw new BusinessValidationException("Teams must be part of the match");
        }

        if (inningsCreateRequest.battingTeamId.equals(inningsCreateRequest.bowlingTeamId)) {
            throw new BusinessValidationException("Batting and bowling teams cannot be the same");
        }

        List<Innings> existingInnings = inningsRepository.findByMatchId(match.getMatchId());
        if (!existingInnings.isEmpty()) {
            boolean inningsExists = existingInnings.stream()
                    .anyMatch(innings -> innings.getInningsNumber() == inningsCreateRequest.inningsNumber);

            if (inningsExists) {
                throw new BusinessValidationException("Innings number already exists for this match");
            }
        }

        Innings innings = new Innings(inningsCreateRequest.matchId, inningsCreateRequest.inningsNumber, inningsCreateRequest.battingTeamId, inningsCreateRequest.bowlingTeamId);
        innings.setOverIds(new ArrayList<>());
        innings.setInningsStatus(InningsStatus.DECLARED);

        Innings savedInnings = inningsRepository.save(innings);

        matchRepository.addInningsToMatch(match.getMatchId(), savedInnings.getInningsId());

        logger.info("Successfully created innings with ID: " + savedInnings.getInningsId());
        return savedInnings;
    }

    public Innings getInningsById(String inningsId) {
        logger.debug("Fetching innings with ID: " + inningsId);
        return inningsRepository.getById(inningsId);
    }

    public Innings updateInnings(String inningsId, InningsUpdateRequest inningsUpdateRequest) {
        logger.info("Updating innings with id: " + inningsId);
        Innings existingInnings = inningsRepository.getById(inningsId);

        Match match = matchRepository.getById(existingInnings.getMatchId());
        if (match.getMatchStatus() != MatchStatus.LIVE) {
            throw new BusinessValidationException("Cannot update innings for a non-live match");
        }

        if (inningsUpdateRequest.inningsStatus != null) {
            existingInnings.setInningsStatus(inningsUpdateRequest.inningsStatus);
        }

        Innings updatedInnings = inningsRepository.update(existingInnings);
        logger.info("Successfully updated innings with ID: " + inningsId);
        return updatedInnings;
    }

    public void deleteInnings(String inningsId) {
        logger.info("Deleting innings with id: " + inningsId);
        Innings existingInnings = inningsRepository.getById(inningsId);

        Match match = matchRepository.getById(existingInnings.getMatchId());
        if (match.getMatchStatus() != MatchStatus.LIVE) {
            throw new BusinessValidationException("Cannot delete innings for a non-live match");
        }

        match.getInningsIds().remove(inningsId);
        matchRepository.update(match);

        // TODO: Handle deletion of dependent overs/balls
        inningsRepository.deleteById(inningsId);
        logger.info("Successfully deleted innings with ID: " + inningsId);
    }

    public List<Innings> findInnings(InningsSearchRequest inningsSearchRequest) {
        logger.debug("Finding innings with filters");
        return inningsRepository.findAll().stream().filter((innings) -> {
            boolean matchIdFilter = inningsSearchRequest.matchId == null ||
                    innings.getMatchId().equals(inningsSearchRequest.matchId);
            boolean inningsNumberFilter = inningsSearchRequest.inningsNumber == null ||
                    innings.getInningsNumber() == inningsSearchRequest.inningsNumber;
            boolean battingTeamIdFilter = inningsSearchRequest.battingTeamId == null ||
                    innings.getBattingTeamId().equals(inningsSearchRequest.battingTeamId);
            boolean bowlingTeamIdFilter = inningsSearchRequest.bowlingTeamId == null ||
                    innings.getBowlingTeamId().equals(inningsSearchRequest.bowlingTeamId);
            boolean statusFilter = inningsSearchRequest.inningsStatus == null ||
                    innings.getInningsStatus().equals(inningsSearchRequest.inningsStatus);

            return matchIdFilter && inningsNumberFilter && battingTeamIdFilter &&
                    bowlingTeamIdFilter && statusFilter;
        }).toList();
    }

    public void addOverToInnings(String inningsId, String overId) {
        logger.info("Adding over " + overId + " to innings " + inningsId);
        Innings innings = inningsRepository.getById(inningsId);

        if (innings.getInningsStatus() != InningsStatus.IN_PROGRESS) {
            throw new BusinessValidationException("Cannot add over to a non-in-progress innings");
        }

        List<String> overs = innings.getOverIds();
        overs.add(overId);
        innings.setOverIds(overs);
        inningsRepository.update(innings);
        logger.info("Successfully added over to innings");
    }

    private void validateInningsCreateRequest(InningsCreateRequest inningsCreateRequest) {
        validateNotNull(inningsCreateRequest.matchId, "Match ID");
        validateNotNull(inningsCreateRequest.battingTeamId, "Batting team ID");
        validateNotNull(inningsCreateRequest.bowlingTeamId, "Bowling team ID");

        if (inningsCreateRequest.inningsNumber <= 0) {
            throw new BusinessValidationException("Innings number must be positive");
        }
    }

    private void validateNotNull(Object fieldValue, String fieldName) {
        if (fieldValue == null) {
            throw new BusinessValidationException(String.format("%s cannot be empty", fieldName));
        }
    }
}