package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.models.Match;
import org.example.caseStudies.designCricinfo.models.Team;
import org.example.caseStudies.designCricinfo.models.Tournament;
import org.example.caseStudies.designCricinfo.models.dto.MatchCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.MatchSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.MatchUpdateRequest;
import org.example.caseStudies.designCricinfo.models.enums.MatchStatus;
import org.example.caseStudies.designCricinfo.repository.MatchRepository;
import org.example.caseStudies.designCricinfo.repository.TeamRepository;
import org.example.caseStudies.designCricinfo.repository.TournamentRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MatchService {
    private final Logger logger = Logger.getInstance();
    private final TournamentRepository tournamentRepository = TournamentRepository.getInstance();
    private final TeamRepository teamRepository = TeamRepository.getInstance();
    private final MatchRepository matchRepository = MatchRepository.getInstance();

    public Match createMatch(MatchCreateRequest matchCreateRequest) {
        logger.info("Creating new match: " + matchCreateRequest);
        boolean isTournamentMatch = matchCreateRequest.tournamentId != null;
        Tournament tournament = tournamentRepository.getById(matchCreateRequest.tournamentId);

        List<Team> teams = new ArrayList<>();
        for (String teamId : matchCreateRequest.teamIds) {
            Team team = teamRepository.getById(teamId);
            teams.add(team);
            if (isTournamentMatch && !tournament.getTeamIds().contains(teamId)) {
                throw new BusinessValidationException(
                        String.format("Team %s is not part of tournament %s", team.getTeamName(), tournament.getTournamentName())
                );
            }
        }

        if (matchCreateRequest.teamIds.size() != 2) {
            throw new BusinessValidationException("A match must have exactly 2 teams");
        }
        Match match = new Match(matchCreateRequest.teamIds, matchCreateRequest.matchFormat);
        match.setInningsIds(new ArrayList<>());
        match.setMatchStatus(MatchStatus.UPCOMING);
        Match savedMatch = matchRepository.save(match);

        tournamentRepository.addMatchToTournament(tournament.getTournamentId(), savedMatch.getMatchId());
        logger.info("Successfully created match with ID: " + savedMatch.getMatchId());
        return savedMatch;
    }

    public Match getMatchById(String matchId) {
        logger.debug("Fetching match with ID: " + matchId);
        return matchRepository.getById(matchId);
    }

    public Match updateMatch(String matchId, MatchUpdateRequest matchUpdateRequest)
    {
        logger.info("Updating match with id: " + matchId);
        Match existingMatch = matchRepository.getById(matchId);
        MatchStatus matchStatus = existingMatch.getMatchStatus();
        validateMatchStatus(matchStatus);
        if(matchUpdateRequest.tournamentId != null && !matchUpdateRequest.tournamentId.equals(existingMatch.getTournamentId()))
        {
            tournamentRepository.getById(matchUpdateRequest.venueId);
        }

        LocalDateTime startDate = matchUpdateRequest.startDate != null ? matchUpdateRequest.startDate : existingMatch.getStartDate();
        LocalDateTime endDate = matchUpdateRequest.endDate != null ? matchUpdateRequest.endDate : existingMatch.getEndDate();

        if(startDate.isAfter(endDate))
        {
            throw new BusinessValidationException("Match end date cannot be before start date");
        }
        logger.info("Successfully updated match with ID: " + matchId);
        return matchRepository.update(existingMatch);
    }

    public void deleteMatch(String matchId)
    {
        logger.info("Deleting match with id: " + matchId);
        Match existingMatch = matchRepository.getById(matchId);
        MatchStatus matchStatus = existingMatch.getMatchStatus();
        validateMatchStatus(matchStatus);

        if(existingMatch.getStartDate() != null && existingMatch.getStartDate().isBefore(LocalDateTime.now()))
        {
            throw new BusinessValidationException("Cannot delete a match that has already started");
        }

        if(existingMatch.getTournamentId() != null)
        {
            Tournament tournament = tournamentRepository.getById(existingMatch.getTournamentId());
            tournament.getMatchIds().remove(matchId);
            tournamentRepository.update(tournament);
        }
        matchRepository.deleteById(matchId);
        logger.info("Successfully deleted match with ID: " + matchId);
    }

    private List<Match> findMatches(MatchSearchRequest matchSearchRequest)
    {
        logger.debug("Finding matches with filters");
        return matchRepository.findAll().stream().filter((match) -> {
            boolean tournamentFilter = matchSearchRequest.tournamentId == null || (match.getTournamentId() != null && match.getTournamentId().equals(matchSearchRequest.tournamentId));
            boolean formatFilter = matchSearchRequest.format == null || (match.getFormat() != null && match.getFormat().equals(matchSearchRequest.format));
            boolean matchStatusFilter = matchSearchRequest.matchStatus == null || (match.getMatchStatus() != null && match.getMatchStatus().equals(matchSearchRequest.matchStatus));
            boolean venueIdFilter = matchSearchRequest.venueId == null || (match.getVenueId() != null && match.getVenueId().equals(matchSearchRequest.venueId));
            boolean startDateFilter = matchSearchRequest.startDate == null || (match.getStartDate() != null && match.getStartDate().isAfter(LocalDateTime.now()));
            boolean endDateFilter = matchSearchRequest.endDate == null || (match.getEndDate() != null && match.getEndDate().isBefore(LocalDateTime.now()));

            return tournamentFilter && formatFilter && matchStatusFilter && venueIdFilter && startDateFilter && endDateFilter;
        }).toList();
    }

    private void validateMatchStatus(MatchStatus matchStatus)
    {
        if(matchStatus.equals(MatchStatus.LIVE) || matchStatus.equals(MatchStatus.COMPLETED) || matchStatus.equals(MatchStatus.ABANDONED))
        {
            throw new BusinessValidationException(
                    "Cannot modify/delete a " + matchStatus.name() + " match"
            );
        }
    }
}
