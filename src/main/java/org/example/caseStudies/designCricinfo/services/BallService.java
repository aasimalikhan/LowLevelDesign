package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.factory.ExtraRunsDetailsFactory;
import org.example.caseStudies.designCricinfo.models.Ball;
import org.example.caseStudies.designCricinfo.models.Over;
import org.example.caseStudies.designCricinfo.models.Player;
import org.example.caseStudies.designCricinfo.models.dto.ball.BallCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.ball.BallSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.ball.BallUpdateRequest;
import org.example.caseStudies.designCricinfo.models.enums.BallResult;
import org.example.caseStudies.designCricinfo.models.enums.ExtraType;
import org.example.caseStudies.designCricinfo.repository.BallRepository;
import org.example.caseStudies.designCricinfo.repository.OverRepository;
import org.example.caseStudies.designCricinfo.repository.PlayerRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.util.List;

public class BallService {
    private final Logger logger = Logger.getInstance();
    private final BallRepository ballRepository = BallRepository.getInstance();
    private final OverRepository overRepository = OverRepository.getInstance();
    private final PlayerRepository playerRepository = PlayerRepository.getInstance();

    public Ball createBall(BallCreateRequest ballCreateRequest) {
        logger.info("Creating new ball: " + ballCreateRequest);

        validateBallCreateRequest(ballCreateRequest);

        Over over = overRepository.getById(ballCreateRequest.overId);

        Player bowler = playerRepository.getById(ballCreateRequest.bowlerId);
        Player batsman = playerRepository.getById(ballCreateRequest.batsmanId);
        Player nonStriker = playerRepository.getById(ballCreateRequest.nonStrikerId);

        if (ballCreateRequest.isWicket && ballCreateRequest.wicketType != null &&
                ballCreateRequest.wicketType.requiredFielder() &&
                ballCreateRequest.fielderId == null) {
            throw new BusinessValidationException("Fielder is required for this wicket type");
        }

        if (ballCreateRequest.fielderId != null) {
            playerRepository.getById(ballCreateRequest.fielderId);
        }

        if(ballCreateRequest.runsScored == null)
        {
            throw new BusinessValidationException("Runs scored cannot be empty");
        }

        if (!over.getBowlerId().equals(ballCreateRequest.bowlerId)) {
            throw new BusinessValidationException("Bowler does not match the over's bowler");
        }

        Ball ball = new Ball(ballCreateRequest.overId, ballCreateRequest.ballNumber, ballCreateRequest.bowlerId, ballCreateRequest.batsmanId, ballCreateRequest.nonStrikerId, ballCreateRequest.runsScored, ballCreateRequest.ballResult);

        if(ballCreateRequest.extraType != null)
        {
            Integer extraRuns = ExtraRunsDetailsFactory.getRunsForExtraDelivery(ballCreateRequest.extraType);

            // NOTE - a command can be given as BALL EXTRA WIDE (runs scored by batsman)
            // BALL EXTRA WIDE 3 (means 3 runs have been scored by batsman)
            // total number of runs including the wide which will be considered for extra is 4
            // so the specified will be in runsScored property, but after processing it will go to the extraRuns

            Integer extraDeliveryTotalRunsScored = ball.getRunsScored() + extraRuns;
            ball.setRunsScored(0);
            ball.setExtraRuns(extraDeliveryTotalRunsScored);
        }
        ball.setExtraType(ballCreateRequest.extraType);
        ball.setWicket(ballCreateRequest.isWicket);
        ball.setWicketType(ballCreateRequest.wicketType);
        ball.setFielderId(ballCreateRequest.fielderId);
        ball.setBallResult(ballCreateRequest.ballResult);

        Ball savedBall = ballRepository.save(ball);

        overRepository.addBallToOver(over.getOverId(), savedBall.getBallId());

        logger.info("Successfully created ball with ID: " + savedBall.getBallId());
        return savedBall;
    }

    public Ball getBallById(String ballId) {
        logger.debug("Fetching ball with ID: " + ballId);
        return ballRepository.getById(ballId);
    }

    public Integer getTotalRunsForBall(String ballId)
    {
        Ball ball = getBallById(ballId);
        Integer totalRuns = ball.getRunsScored();
        totalRuns += ball.getExtraRuns();
        return totalRuns;
    }

    public Integer getBatsmanRunsForBall(String ballId)
    {
        Ball ball = getBallById(ballId);
        return ball.getRunsScored();
    }

    public Ball updateBall(String ballId, BallUpdateRequest ballUpdateRequest) {
        logger.info("Updating ball with id: " + ballId);
        Ball existingBall = ballRepository.getById(ballId);

        Over over = overRepository.getById(existingBall.getOverId());
        if (over.isCompleted()) {
            throw new BusinessValidationException("Cannot update ball in a completed over");
        }

        if (ballUpdateRequest.runsScored != null &&
                isPropertyChanged(existingBall.getRunsScored(), ballUpdateRequest.runsScored)) {
            existingBall.setRunsScored(ballUpdateRequest.runsScored);
        }

        if (ballUpdateRequest.extraType != null &&
                isPropertyChanged(existingBall.getExtraType(), ballUpdateRequest.extraType)) {
            existingBall.setExtraType(ballUpdateRequest.extraType);

            if (ballUpdateRequest.extraRuns != null &&
                    isPropertyChanged(existingBall.getExtraRuns(), ballUpdateRequest.extraRuns)) {
                existingBall.setExtraRuns(ballUpdateRequest.extraRuns);
            }
        }

        if (ballUpdateRequest.isWicket != null &&
                isPropertyChanged(existingBall.isWicket(), ballUpdateRequest.isWicket)) {
            existingBall.setWicket(ballUpdateRequest.isWicket);
        }

        if (ballUpdateRequest.isWicket == true && ballUpdateRequest.wicketType != null &&
                isPropertyChanged(existingBall.getWicketType(), ballUpdateRequest.wicketType)) {
            existingBall.setWicketType(ballUpdateRequest.wicketType);
        }

        if (ballUpdateRequest.isWicket && ballUpdateRequest.wicketType != null && ballUpdateRequest.wicketType.requiredFielder() && ballUpdateRequest.fielderId != null) {
            playerRepository.getById(ballUpdateRequest.fielderId);
            existingBall.setFielderId(ballUpdateRequest.fielderId);
        }

        if (ballUpdateRequest.ballResult != null &&
                isPropertyChanged(existingBall.getBallResult(), ballUpdateRequest.ballResult)) {
            existingBall.setBallResult(ballUpdateRequest.ballResult);
        }

        Ball updatedBall = ballRepository.update(existingBall);
        logger.info("Successfully updated ball with ID: " + ballId);
        return updatedBall;
    }

    public void deleteBall(String ballId) {
        logger.info("Deleting ball with id: " + ballId);
        Ball existingBall = ballRepository.getById(ballId);

        Over over = overRepository.getById(existingBall.getOverId());
        if (over.isCompleted()) {
            throw new BusinessValidationException("Cannot delete ball from a completed over");
        }
        //TODO - remove all references of this deleted bal from the Overs also
        over.getBallIds().remove(ballId);
        overRepository.update(over);

        ballRepository.deleteById(ballId);
        logger.info("Successfully deleted ball with ID: " + ballId);
    }

    public List<Ball> findBalls(BallSearchRequest ballSearchRequest) {
        logger.debug("Finding balls with filters");
        return ballRepository.findAll().stream().filter((ball) -> {
            boolean overIdFilter = ballSearchRequest.overId == null ||
                    ball.getOverId().equals(ballSearchRequest.overId);
            boolean ballNumberFilter = ballSearchRequest.ballNumber == null ||
                    ball.getBallNumber() == ballSearchRequest.ballNumber;
            boolean bowlerIdFilter = ballSearchRequest.bowlerId == null ||
                    ball.getBowlerId().equals(ballSearchRequest.bowlerId);
            boolean batsmanIdFilter = ballSearchRequest.batsmanId == null ||
                    ball.getBatsmanId().equals(ballSearchRequest.batsmanId);
            boolean isWicketFilter = ballSearchRequest.isWicket == null ||
                    ball.isWicket() == ballSearchRequest.isWicket;
            boolean wicketTypeFilter = ballSearchRequest.wicketType == null ||
                    (ball.getWicketType() != null &&
                            ball.getWicketType().equals(ballSearchRequest.wicketType));
            boolean extraTypeFilter = ballSearchRequest.extraType == null ||
                    (ball.getExtraType().equals(ballSearchRequest.extraType));
            boolean ballResultFilter = ballSearchRequest.ballResult == null ||
                    (ball.getBallResult().equals(ballSearchRequest.ballResult));

            return overIdFilter && ballNumberFilter && bowlerIdFilter &&
                    batsmanIdFilter && isWicketFilter && wicketTypeFilter && extraTypeFilter && ballResultFilter;
        }).toList();
    }

    public List<Ball> findExtraBalls(String overId)
    {
        BallSearchRequest ballSearchRequest = new BallSearchRequest();
        ballSearchRequest.overId = overId;
        ballSearchRequest.ballResult = BallResult.EXTRA;
        return findBalls(ballSearchRequest);
    }

    private void validateBallCreateRequest(BallCreateRequest ballCreateRequest) {
        validateNotNull(ballCreateRequest.overId, "Over ID");
        validateNotNull(ballCreateRequest.bowlerId, "Bowler ID");
        validateNotNull(ballCreateRequest.batsmanId, "Batsman ID");
        validateNotNull(ballCreateRequest.nonStrikerId, "Non-striker ID");
        validateNotNull(ballCreateRequest.ballResult, "Ball result");
        validateNotNull(ballCreateRequest.runsScored, "Runs scored");

        if (ballCreateRequest.ballNumber <= 0) {
            throw new BusinessValidationException("Ball number must be positive");
        }

        if (ballCreateRequest.isWicket && ballCreateRequest.wicketType == null) {
            throw new BusinessValidationException("Wicket type is required when ball is a wicket");
        }
    }

    private void validateNotNull(Object fieldValue, String fieldName) {
        if (fieldValue == null) {
            throw new BusinessValidationException(String.format("%s cannot be empty", fieldName));
        }
    }

    private boolean isPropertyChanged(Object previous, Object existing)
    {
        return !previous.equals(existing);
    }
}