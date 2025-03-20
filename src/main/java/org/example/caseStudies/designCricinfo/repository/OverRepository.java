package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Over;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OverRepository {
    private final Map<String, Over> overStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static OverRepository overRepository;

    public static OverRepository getInstance()
    {
        if(overRepository == null)
        {
            synchronized (OverRepository.class)
            {
                overRepository = new OverRepository();
            }
        }
        return overRepository;
    }

    private OverRepository() {
        this.overStore = new HashMap<>();
    }

    public Over save(Over over) {
        if(over.getOverId() != null && overStore.containsKey(over.getOverId())) {
            throw new DuplicateEntityException("Over", over.getOverId());
        }

        if(over.getOverId() == null) {
            String id = "OVER-" + idCounter.incrementAndGet();
            over.setOverId(id);
        }

        overStore.put(over.getOverId(), over);
        return over;
    }

    public Optional<Over> findById(String overId) {
        return Optional.ofNullable(overStore.get(overId));
    }

    public Over getById(String overId) {
        return findById(overId).orElseThrow(() -> new EntityNotFoundException("Over", overId));
    }

    public Over update(Over over) {
        if(over.getOverId() == null || !overStore.containsKey(over.getOverId())) {
            throw new EntityNotFoundException("Over", over.getOverId() == null ? "null" : over.getOverId());
        }

        overStore.put(over.getOverId(), over);
        return over;
    }

    public void deleteById(String overId) {
        if(!overStore.containsKey(overId)) {
            throw new EntityNotFoundException("Over", overId);
        }
        overStore.remove(overId);
    }

    public boolean existsById(String overId) {
        return overStore.containsKey(overId);
    }

    public List<Over> findAll() {
        return new ArrayList<>(overStore.values());
    }

    public List<Over> findByInningsId(String inningsId) {
        return overStore.values().stream()
                .filter(over -> over.getInningsId().equals(inningsId))
                .toList();
    }

    public List<Over> findByBowlerId(String bowlerId) {
        return overStore.values().stream()
                .filter(over -> over.getBowlerId().equals(bowlerId))
                .toList();
    }

    public List<Over> findCompletedOvers(String inningsId) {
        return overStore.values().stream()
                .filter(over -> over.getInningsId().equals(inningsId) && over.isCompleted())
                .toList();
    }

    public Optional<Over> findCurrentOver(String inningsId) {
        return overStore.values().stream()
                .filter(over -> over.getInningsId().equals(inningsId) && !over.isCompleted())
                .findFirst();
    }

    public void addBallToOver(String overId, String ballId) {
        Over over = getById(overId);
        List<String> balls = over.getBallIds();
        balls.add(ballId);
        over.setBallIds(balls);
        update(over);
    }
}