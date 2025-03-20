package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Match;
import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MatchRepository {
    private final Map<String, Match> matchStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static MatchRepository matchRepository;

    public static MatchRepository getInstance()
    {
        if(matchRepository == null)
        {
            synchronized (MatchRepository.class)
            {
                matchRepository = new MatchRepository();
            }
        }
        return matchRepository;
    }

    private MatchRepository() {
        this.matchStore = new HashMap<>();
    }

    public Match save(Match match) {
        if(match.getMatchId() != null && matchStore.containsKey(match.getMatchId())) {
            throw new DuplicateEntityException("Match", match.getMatchId());
        }

        if(match.getMatchId() == null) {
            String id = "MATCH-" + idCounter.incrementAndGet();
            match.setMatchId(id);
        }

        matchStore.put(match.getMatchId(), match);
        return match;
    }

    public Optional<Match> findById(String matchId) {
        return Optional.ofNullable(matchStore.get(matchId));
    }

    public Match getById(String matchId) {
        return findById(matchId).orElseThrow(() -> new EntityNotFoundException("Match", matchId));
    }

    public Match update(Match match) {
        if(match.getMatchId() == null || !matchStore.containsKey(match.getMatchId())) {
            throw new EntityNotFoundException("Match", match.getMatchId() == null ? "null" : match.getMatchId());
        }

        matchStore.put(match.getMatchId(), match);
        return match;
    }

    public void deleteById(String matchId) {
        if(!matchStore.containsKey(matchId)) {
            throw new EntityNotFoundException("Match", matchId);
        }
        matchStore.remove(matchId);
    }

    public boolean existsById(String matchId) {
        return matchStore.containsKey(matchId);
    }

    public List<Match> findAll() {
        return new ArrayList<>(matchStore.values());
    }

    public List<Match> findByTournamentId(String tournamentId) {
        return matchStore.values().stream()
                .filter(match -> match.getTournamentId().equals(tournamentId))
                .toList();
    }

    public List<Match> findByVenueId(String venueId) {
        return matchStore.values().stream()
                .filter(match -> match.getVenueId().equals(venueId))
                .toList();
    }

    public List<Match> findByTeamId(String teamId) {
        return matchStore.values().stream()
                .filter(match -> match.getTeamIds().contains(teamId))
                .toList();
    }

    public List<Match> findByFormat(MatchFormat format) {
        return matchStore.values().stream()
                .filter(match -> match.getFormat().equals(format))
                .toList();
    }

    public List<Match> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return matchStore.values().stream()
                .filter(match -> !match.getStartDate().isBefore(startDate) &&
                        !match.getEndDate().isAfter(endDate))
                .toList();
    }

    public List<Match> findUpcomingMatches() {
        LocalDateTime now = LocalDateTime.now();
        return matchStore.values().stream()
                .filter(match -> match.getStartDate().isAfter(now))
                .toList();
    }

    public List<Match> findOngoingMatches() {
        LocalDateTime now = LocalDateTime.now();
        return matchStore.values().stream()
                .filter(match -> match.getStartDate().isBefore(now) &&
                        match.getEndDate().isAfter(now))
                .toList();
    }

    public void addInningsToMatch(String matchId, String inningsId) {
        Match match = getById(matchId);
        List<String> innings = new ArrayList<>(match.getInningsIds());
        innings.add(inningsId);
        match.setInningsIds(innings);
        update(match);
    }
}