package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.models.Tournament;
import org.example.caseStudies.designCricinfo.models.Team;
import org.example.caseStudies.designCricinfo.models.dto.tournament.TournamentCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.tournament.TournamentSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.tournament.TournamentUpdateRequest;
import org.example.caseStudies.designCricinfo.models.enums.TournamentStatus;
import org.example.caseStudies.designCricinfo.repository.TournamentRepository;
import org.example.caseStudies.designCricinfo.repository.TeamRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class TournamentService {
    private final Logger logger = Logger.getInstance();
    private final TournamentRepository tournamentRepository = TournamentRepository.getInstance();
    private final TeamRepository teamRepository = TeamRepository.getInstance();

    public Tournament createTournament(TournamentCreateRequest tournamentCreateRequest) {
        logger.info("Creating new tournament: " + tournamentCreateRequest);

        validateTournamentCreateRequest(tournamentCreateRequest);

        // Validate all team IDs exist
        List<String> teamIds = new ArrayList<>();
        if (tournamentCreateRequest.teamIds != null && !tournamentCreateRequest.teamIds.isEmpty()) {
            for (String teamId : tournamentCreateRequest.teamIds) {
                Team team = teamRepository.getById(teamId); // This will throw exception if team doesn't exist
                teamIds.add(team.getTeamId());
            }
        }

        Tournament tournament = new Tournament(tournamentCreateRequest.tournamentName, tournamentCreateRequest.format);
        tournament.setTeamIds(teamIds);
        tournament.setMatchIds(new ArrayList<>());
        tournament.setStatus(TournamentStatus.UPCOMING);

        Tournament savedTournament = tournamentRepository.save(tournament);
        logger.info("Successfully created tournament with ID: " + savedTournament.getTournamentId());
        return savedTournament;
    }

    public Tournament getTournamentById(String tournamentId) {
        logger.debug("Fetching tournament with ID: " + tournamentId);
        return tournamentRepository.getById(tournamentId);
    }

    public Tournament updateTournament(String tournamentId, TournamentUpdateRequest tournamentUpdateRequest) {
        logger.info("Updating tournament with id: " + tournamentId);
        Tournament existingTournament = tournamentRepository.getById(tournamentId);

        if (existingTournament.getStatus() == TournamentStatus.COMPLETED) {
            throw new BusinessValidationException("Cannot update a completed tournament");
        }

        if (existingTournament.getStatus() == TournamentStatus.IN_PROGRESS &&
                (tournamentUpdateRequest.teamIds != null || tournamentUpdateRequest.startDate != null)) {
            throw new BusinessValidationException("Cannot update teams or start date for an in-progress tournament");
        }

        if (tournamentUpdateRequest.tournamentName != null) {
            existingTournament.setTournamentName(tournamentUpdateRequest.tournamentName);
        }

        if (tournamentUpdateRequest.teamIds != null) {
            List<String> newTeamIds = new ArrayList<>();
            for (String teamId : tournamentUpdateRequest.teamIds) {
                Team team = teamRepository.getById(teamId);
                newTeamIds.add(team.getTeamId());
            }
            existingTournament.setTeamIds(newTeamIds);
        }

        LocalDate startDate = tournamentUpdateRequest.startDate != null ?
                tournamentUpdateRequest.startDate : existingTournament.getStartDate();
        LocalDate endDate = tournamentUpdateRequest.endDate != null ?
                tournamentUpdateRequest.endDate : existingTournament.getEndDate();

        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new BusinessValidationException("Tournament end date cannot be before start date");
        }

        existingTournament.setStartDate(startDate);
        existingTournament.setEndDate(endDate);

        if (tournamentUpdateRequest.status != null) {
            validateStatusTransition(existingTournament.getStatus(), tournamentUpdateRequest.status);
            existingTournament.setStatus(tournamentUpdateRequest.status);
        }

        Tournament updatedTournament = tournamentRepository.update(existingTournament);
        logger.info("Successfully updated tournament with ID: " + tournamentId);
        return updatedTournament;
    }

    public void deleteTournament(String tournamentId) {
        logger.info("Deleting tournament with id: " + tournamentId);
        Tournament existingTournament = tournamentRepository.getById(tournamentId);

        if (existingTournament.getStatus() != TournamentStatus.UPCOMING) {
            throw new BusinessValidationException("Can only delete tournaments that haven't started yet");
        }

        if (existingTournament.getMatchIds() != null && !existingTournament.getMatchIds().isEmpty()) {
            throw new BusinessValidationException("Cannot delete tournament with existing matches");
        }

        tournamentRepository.deleteById(tournamentId);
        logger.info("Successfully deleted tournament with ID: " + tournamentId);
    }

    public List<Tournament> findTournaments(TournamentSearchRequest tournamentSearchRequest) {
        logger.debug("Finding tournaments with filters");
        return tournamentRepository.findAll().stream().filter((tournament) -> {
            boolean nameFilter = tournamentSearchRequest.tournamentName == null ||
                    tournament.getTournamentName().toLowerCase().contains(tournamentSearchRequest.tournamentName.toLowerCase());
            boolean formatFilter = tournamentSearchRequest.format == null ||
                    tournament.getFormat().equals(tournamentSearchRequest.format);
            boolean statusFilter = tournamentSearchRequest.status == null ||
                    tournament.getStatus().equals(tournamentSearchRequest.status);
            boolean startDateFilter = tournamentSearchRequest.startDate == null ||
                    (tournament.getStartDate() != null && tournament.getStartDate().equals(tournamentSearchRequest.startDate));
            boolean endDateFilter = tournamentSearchRequest.endDate == null ||
                    (tournament.getEndDate() != null && tournament.getEndDate().equals(tournamentSearchRequest.endDate));

            return nameFilter && formatFilter && statusFilter && startDateFilter && endDateFilter;
        }).toList();
    }

    public void addTeamToTournament(String tournamentId, String teamId) {
        logger.info("Adding team " + teamId + " to tournament " + tournamentId);
        Tournament tournament = tournamentRepository.getById(tournamentId);
        Team team = teamRepository.getById(teamId);

        if (tournament.getStatus() != TournamentStatus.UPCOMING) {
            throw new BusinessValidationException("Cannot add teams to a tournament that has already started");
        }

        LinkedHashSet<String> teamIds = tournament.getTeamIds();
        if (teamIds == null) {
            teamIds = new LinkedHashSet<>();
        }

        if (teamIds.contains(teamId)) {
            throw new BusinessValidationException("Team is already part of the tournament");
        }

        teamIds.add(teamId);
        tournament.setTeamIds(teamIds);
        tournamentRepository.update(tournament);
        logger.info("Successfully added team to tournament");
    }

    public void removeTeamFromTournament(String tournamentId, String teamId) {
        logger.info("Removing team " + teamId + " from tournament " + tournamentId);
        Tournament tournament = tournamentRepository.getById(tournamentId);

        if (tournament.getStatus() != TournamentStatus.UPCOMING) {
            throw new BusinessValidationException("Cannot remove teams from a tournament that has already started");
        }

        LinkedHashSet<String> teamIds = tournament.getTeamIds();
        if (teamIds == null || !teamIds.contains(teamId)) {
            throw new BusinessValidationException("Team is not part of the tournament");
        }

        // Check if the team is involved in any matches
        if (tournament.getMatchIds() != null && !tournament.getMatchIds().isEmpty()) {
            throw new BusinessValidationException("Cannot remove team that has existing matches in the tournament");
        }

        teamIds.remove(teamId);
        tournament.setTeamIds(teamIds);
        tournamentRepository.update(tournament);
        logger.info("Successfully removed team from tournament");
    }

    public void addMatchToTournament(String tournamentId, String matchId) {
        logger.info("Adding match " + matchId + " to tournament " + tournamentId);
        Tournament tournament = tournamentRepository.getById(tournamentId);

        if (tournament.getStatus() == TournamentStatus.COMPLETED) {
            throw new BusinessValidationException("Cannot add matches to a completed tournament");
        }

        LinkedHashSet<String> matchIds = tournament.getMatchIds();
        if (matchIds == null) {
            matchIds = new LinkedHashSet<>();
        }

        if (matchIds.contains(matchId)) {
            throw new BusinessValidationException("Match is already part of the tournament");
        }

        matchIds.add(matchId);
        tournament.setMatchIds(matchIds);
        tournamentRepository.update(tournament);
        logger.info("Successfully added match to tournament");
    }

    private void validateTournamentCreateRequest(TournamentCreateRequest tournamentCreateRequest) {
        validateNotNull(tournamentCreateRequest.tournamentName, "Tournament name");
        validateNotNull(tournamentCreateRequest.format, "Tournament format");
    }

    private void validateStatusTransition(TournamentStatus currentStatus, TournamentStatus newStatus) {
        // Define valid transitions
        if (currentStatus == TournamentStatus.UPCOMING) {
            // UPCOMING can transition to IN_PROGRESS or CANCELED
            if (newStatus != TournamentStatus.IN_PROGRESS && newStatus != TournamentStatus.CANCELED) {
                throw new BusinessValidationException("Invalid status transition from " + currentStatus + " to " + newStatus);
            }
        } else if (currentStatus == TournamentStatus.IN_PROGRESS) {
            // IN_PROGRESS can transition to COMPLETED or CANCELED
            if (newStatus != TournamentStatus.COMPLETED && newStatus != TournamentStatus.CANCELED) {
                throw new BusinessValidationException("Invalid status transition from " + currentStatus + " to " + newStatus);
            }
        } else if (currentStatus == TournamentStatus.COMPLETED || currentStatus == TournamentStatus.CANCELED) {
            // COMPLETED or CANCELED cannot transition
            throw new BusinessValidationException("Cannot change status from " + currentStatus);
        }
    }

    private void validateNotNull(Object fieldValue, String fieldName) {
        if (fieldValue == null) {
            throw new BusinessValidationException(String.format("%s cannot be empty", fieldName));
        }
    }
}