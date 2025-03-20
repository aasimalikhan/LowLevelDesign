package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Tournament;
import org.example.caseStudies.designCricinfo.models.enums.TournamentFormat;
import org.example.caseStudies.designCricinfo.models.enums.TournamentStatus;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TournamentRepository {
    private final Map<String, Tournament> tournamentStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static TournamentRepository tournamentRepository;

    public static TournamentRepository getInstance()
    {
        if(tournamentRepository == null)
        {
            synchronized (TournamentRepository.class)
            {
                tournamentRepository = new TournamentRepository();
            }
        }
        return tournamentRepository;
    }

    private TournamentRepository() {
        this.tournamentStore = new HashMap<>();
    }

    public Tournament save(Tournament tournament) {
        if(tournament.getTournamentId() != null && tournamentStore.containsKey(tournament.getTournamentId())) {
            throw new DuplicateEntityException("Tournament", tournament.getTournamentId());
        }

        if(tournament.getTournamentId() == null) {
            String id = "TOURNAMENT-" + idCounter.incrementAndGet();
            tournament.setTournamentId(id);
        }

        tournamentStore.put(tournament.getTournamentId(), tournament);
        return tournament;
    }

    public Optional<Tournament> findById(String tournamentId) {
        return Optional.ofNullable(tournamentStore.get(tournamentId));
    }

    public Tournament getById(String tournamentId) {
        return findById(tournamentId).orElseThrow(() -> new EntityNotFoundException("Tournament", tournamentId));
    }

    public Tournament update(Tournament tournament) {
        if(tournament.getTournamentId() == null || !tournamentStore.containsKey(tournament.getTournamentId())) {
            throw new EntityNotFoundException("Tournament", tournament.getTournamentId() == null ? "null" : tournament.getTournamentId());
        }

        tournamentStore.put(tournament.getTournamentId(), tournament);
        return tournament;
    }

    public void deleteById(String tournamentId) {
        if(!tournamentStore.containsKey(tournamentId)) {
            throw new EntityNotFoundException("Tournament", tournamentId);
        }
        tournamentStore.remove(tournamentId);
    }

    public boolean existsById(String tournamentId) {
        return tournamentStore.containsKey(tournamentId);
    }

    public List<Tournament> findAll() {
        return new ArrayList<>(tournamentStore.values());
    }

    public List<Tournament> findByFormat(TournamentFormat format) {
        return tournamentStore.values().stream()
                .filter(tournament -> tournament.getFormat().equals(format))
                .toList();
    }

    public List<Tournament> findByStatus(TournamentStatus status) {
        return tournamentStore.values().stream()
                .filter(tournament -> tournament.getStatus().equals(status))
                .toList();
    }

    public List<Tournament> findByTeamId(String teamId) {
        return tournamentStore.values().stream()
                .filter(tournament -> tournament.getTeamIds().contains(teamId))
                .toList();
    }

    public List<Tournament> findUpcomingTournaments() {
        LocalDate now = LocalDate.now();
        return tournamentStore.values().stream()
                .filter(tournament -> tournament.getStartDate().isAfter(now))
                .toList();
    }

    public List<Tournament> findOngoingTournaments() {
        LocalDate now = LocalDate.now();
        return tournamentStore.values().stream()
                .filter(tournament -> !tournament.getStartDate().isAfter(now) &&
                        !tournament.getEndDate().isBefore(now))
                .toList();
    }

    public void addTeamToTournament(String tournamentId, String teamId) {
        Tournament tournament = getById(tournamentId);
        List<String> teams = tournament.getTeamIds();
        teams.add(teamId);
        tournament.setTeamIds(teams);
        update(tournament);
    }

    public void addMatchToTournament(String tournamentId, String matchId) {
        Tournament tournament = getById(tournamentId);
        List<String> matches = tournament.getMatchIds();
        matches.add(matchId);
        tournament.setMatchIds(matches);
        update(tournament);
    }
}