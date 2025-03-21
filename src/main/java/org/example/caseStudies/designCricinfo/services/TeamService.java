package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.models.Player;
import org.example.caseStudies.designCricinfo.models.Team;
import org.example.caseStudies.designCricinfo.models.Venue;
import org.example.caseStudies.designCricinfo.models.dto.team.TeamCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.team.TeamSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.team.TeamUpdateRequest;
import org.example.caseStudies.designCricinfo.repository.PlayerRepository;
import org.example.caseStudies.designCricinfo.repository.TeamRepository;
import org.example.caseStudies.designCricinfo.repository.VenueRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private final Logger logger = Logger.getInstance();
    private final PlayerRepository playerRepository = PlayerRepository.getInstance();
    private final VenueRepository venueRepository = VenueRepository.getInstance();
    private final TeamRepository teamRepository = TeamRepository.getInstance();

    public Team createTeam(TeamCreateRequest teamCreateRequest)
    {
        logger.info("Creating new team: " + teamCreateRequest);

        List<String> playerIds = new ArrayList<>();
        for(String playerId: teamCreateRequest.playerIdList)
        {
            Player player = playerRepository.getById(playerId);
            playerIds.add(player.getPlayerId());
        }

        Player captain = playerRepository.getById(teamCreateRequest.captainId);
        Venue venue = venueRepository.getById(teamCreateRequest.homeVenueId);

        if(!playerIds.contains(captain.getPlayerId()))
        {
            throw new BusinessValidationException("Captain does not exist in player list");
        }

        if(playerIds.size() < 11)
        {
            throw new BusinessValidationException("A team must have greater than 11 players");
        }
        Team team = new Team(teamCreateRequest.teamName, teamCreateRequest.playerIdList, teamCreateRequest.captainId, teamCreateRequest.homeVenueId);
        Team savedTeam = teamRepository.save(team);
        logger.info("Successfully created team with ID: " + savedTeam.getTeamId());
        return savedTeam;
    }

    public Team getTeamById(String teamId)
    {
        logger.debug("Fetching team with ID: " + teamId);
        return teamRepository.getById(teamId);
    }

    public Team updateTeam(String teamId, TeamUpdateRequest teamUpdateRequest)
    {
        logger.info("Updating team with ID: " + teamId);
        Team existingTeam = teamRepository.getById(teamId);
        if (isPropertyChanged(existingTeam.getTeamName(), teamUpdateRequest.teamName)) {
            existingTeam.setTeamName(teamUpdateRequest.teamName);
        }
        if (isPropertyChanged(existingTeam.getCaptainId(), teamUpdateRequest.captainId)) {
            existingTeam.setCaptainId(teamUpdateRequest.captainId);
        }
        if (isPropertyChanged(existingTeam.getPlayerIdList(), teamUpdateRequest.playerIdList)) {
            existingTeam.setPlayerIdList(teamUpdateRequest.playerIdList);
        }
        if (isPropertyChanged(existingTeam.getHomeVenueId(), teamUpdateRequest.homeVenueId)) {
            existingTeam.setHomeVenueId(teamUpdateRequest.homeVenueId);
        }

        Team updatedTeam = teamRepository.update(existingTeam);
        logger.info("Successfully updated team with ID: " + teamId);
        return updatedTeam;
    }

    public void deleteTeam(String teamId)
    {
        logger.info("Deleting team with id: " + teamId);
        Team existingTeam = teamRepository.getById(teamId);
        //TODO - remove all references of this deleted team from the Innings and Tournaments also
        teamRepository.deleteById(teamId);
        logger.info("Successfully deleted team with ID: " + teamId);
    }

    public List<Team> findTeams(TeamSearchRequest teamSearchRequest)
    {
        logger.debug("Finding teams with filters");
        return teamRepository.findAll().stream().filter((team) -> {
            boolean teamNameFilter = teamSearchRequest.teamName == null || (team.getTeamName() != null && team.getTeamName().equalsIgnoreCase(teamSearchRequest.teamName));
            boolean homeVenueFilter = teamSearchRequest.teamName == null || (team.getHomeVenueId() != null && team.getHomeVenueId().equalsIgnoreCase(teamSearchRequest.homeVenueId));

            return teamNameFilter && homeVenueFilter;
        }).toList();
    }

    private boolean isPropertyChanged(Object previous, Object existing)
    {
        return !previous.equals(existing);
    }
}
