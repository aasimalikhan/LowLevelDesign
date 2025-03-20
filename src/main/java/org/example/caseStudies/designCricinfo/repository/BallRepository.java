package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Ball;
import org.example.caseStudies.designCricinfo.models.enums.ExtraType;
import org.example.caseStudies.designCricinfo.models.enums.WicketType;
import org.example.caseStudies.designCricinfo.models.enums.BallResult;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BallRepository {
    private final Map<String, Ball> ballStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static BallRepository ballRepository;

    public static BallRepository getInstance()
    {
        if(ballRepository == null)
        {
            synchronized (BallRepository.class)
            {
                ballRepository = new BallRepository();
            }
        }
        return ballRepository;
    }

    private BallRepository() {
        this.ballStore = new HashMap<>();
    }

    public Ball save(Ball ball) {
        if(ball.getBallId() != null && ballStore.containsKey(ball.getBallId())) {
            throw new DuplicateEntityException("Ball", ball.getBallId());
        }

        if(ball.getBallId() == null) {
            String id = "BALL-" + idCounter.incrementAndGet();
            ball.setBallId(id);
        }

        ballStore.put(ball.getBallId(), ball);
        return ball;
    }

    public Optional<Ball> findById(String ballId) {
        return Optional.ofNullable(ballStore.get(ballId));
    }

    public Ball getById(String ballId) {
        return findById(ballId).orElseThrow(() -> new EntityNotFoundException("Ball", ballId));
    }

    public Ball update(Ball ball) {
        if(ball.getBallId() == null || !ballStore.containsKey(ball.getBallId())) {
            throw new EntityNotFoundException("Ball", ball.getBallId() == null ? "null" : ball.getBallId());
        }

        ballStore.put(ball.getBallId(), ball);
        return ball;
    }

    public void deleteById(String ballId) {
        if(!ballStore.containsKey(ballId)) {
            throw new EntityNotFoundException("Ball", ballId);
        }
        ballStore.remove(ballId);
    }

    public boolean existsById(String ballId) {
        return ballStore.containsKey(ballId);
    }

    public List<Ball> findAll() {
        return new ArrayList<>(ballStore.values());
    }

    public List<Ball> findByOverId(String overId) {
        return ballStore.values().stream()
                .filter(ball -> ball.getOverId().equals(overId))
                .toList();
    }

    public List<Ball> findByBowlerId(String bowlerId) {
        return ballStore.values().stream()
                .filter(ball -> ball.getBowlerId().equals(bowlerId))
                .toList();
    }

    public List<Ball> findByBatsmanId(String batsmanId) {
        return ballStore.values().stream()
                .filter(ball -> ball.getBatsmanId().equals(batsmanId))
                .toList();
    }

    public List<Ball> findWickets(String overId) {
        return ballStore.values().stream()
                .filter(ball -> ball.getOverId().equals(overId) && ball.isWicket())
                .toList();
    }

    public List<Ball> findByExtraType(ExtraType extraType) {
        return ballStore.values().stream()
                .filter(ball -> extraType.equals(ball.getExtraType()))
                .toList();
    }

    public List<Ball> findByWicketType(WicketType wicketType) {
        return ballStore.values().stream()
                .filter(ball -> ball.isWicket() && wicketType.equals(ball.getWicketType()))
                .toList();
    }

    public List<Ball> findByBallResult(BallResult ballResult) {
        return ballStore.values().stream()
                .filter(ball -> ballResult.equals(ball.getBallResult()))
                .toList();
    }

    public int totalRunsInOver(String overId) {
        return ballStore.values().stream()
                .filter(ball -> ball.getOverId().equals(overId))
                .mapToInt(ball -> ball.getRunsScored() + ball.getExtraRuns())
                .sum();
    }
}