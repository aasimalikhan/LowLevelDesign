package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Innings;
import org.example.caseStudies.designCricinfo.models.enums.InningsStatus;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InningsRepository {
    private final Map<String, Innings> inningsStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static InningsRepository inningsRepository;

    public static InningsRepository getInstance()
    {
        if(inningsRepository == null)
        {
            synchronized (InningsRepository.class)
            {
                if (inningsRepository != null) {
                    inningsRepository = new InningsRepository();
                }
            }
        }
        return inningsRepository;
    }

    private InningsRepository() {
        this.inningsStore = new HashMap<>();
    }

    public Innings save(Innings innings) {
        if(innings.getInningsId() != null && inningsStore.containsKey(innings.getInningsId())) {
            throw new DuplicateEntityException("Innings", innings.getInningsId());
        }

        if(innings.getInningsId() == null) {
            String id = "INNINGS-" + idCounter.incrementAndGet();
            innings.setInningsId(id);
        }

        inningsStore.put(innings.getInningsId(), innings);
        return innings;
    }

    public Optional<Innings> findById(String inningsId) {
        return Optional.ofNullable(inningsStore.get(inningsId));
    }

    public Innings getById(String inningsId) {
        return findById(inningsId).orElseThrow(() -> new EntityNotFoundException("Innings", inningsId));
    }

    public Innings update(Innings innings) {
        if(innings.getInningsId() == null || !inningsStore.containsKey(innings.getInningsId())) {
            throw new EntityNotFoundException("Innings", innings.getInningsId() == null ? "null" : innings.getInningsId());
        }

        inningsStore.put(innings.getInningsId(), innings);
        return innings;
    }

    public void deleteById(String inningsId) {
        if(!inningsStore.containsKey(inningsId)) {
            throw new EntityNotFoundException("Innings", inningsId);
        }
        inningsStore.remove(inningsId);
    }

    public boolean existsById(String inningsId) {
        return inningsStore.containsKey(inningsId);
    }

    public List<Innings> findAll() {
        return new ArrayList<>(inningsStore.values());
    }

    public List<Innings> findByMatchId(String matchId) {
        return inningsStore.values().stream()
                .filter(innings -> innings.getMatchId().equals(matchId))
                .toList();
    }

    public List<Innings> findByBattingTeamId(String teamId) {
        return inningsStore.values().stream()
                .filter(innings -> innings.getBattingTeamId().equals(teamId))
                .toList();
    }

    public List<Innings> findByBowlingTeamId(String teamId) {
        return inningsStore.values().stream()
                .filter(innings -> innings.getBowlingTeamId().equals(teamId))
                .toList();
    }

    public List<Innings> findByStatus(InningsStatus status) {
        return inningsStore.values().stream()
                .filter(innings -> innings.getInningsStatus().equals(status))
                .toList();
    }

    public Optional<Innings> findCurrentInningsByMatchId(String matchId) {
        return inningsStore.values().stream()
                .filter(innings -> innings.getMatchId().equals(matchId) &&
                        innings.getInningsStatus() == InningsStatus.IN_PROGRESS)
                .findFirst();
    }

    public void addOverToInnings(String inningsId, String overId) {
        Innings innings = getById(inningsId);
        List<String> overs = new ArrayList<>(innings.getOverIds());
        overs.add(overId);
        innings.setOverIds(overs);
        update(innings);
    }
}