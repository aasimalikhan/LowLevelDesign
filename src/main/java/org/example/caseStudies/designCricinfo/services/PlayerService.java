package org.example.caseStudies.designCricinfo.services;

import org.example.caseStudies.designCricinfo.exceptions.BusinessValidationException;
import org.example.caseStudies.designCricinfo.models.Player;
import org.example.caseStudies.designCricinfo.models.dto.player.PlayerCreateRequest;
import org.example.caseStudies.designCricinfo.models.dto.player.PlayerSearchRequest;
import org.example.caseStudies.designCricinfo.models.dto.player.PlayerUpdateRequest;
import org.example.caseStudies.designCricinfo.repository.PlayerRepository;
import org.example.caseStudies.designLoggingFramework.models.Logger;

import java.util.List;

public class PlayerService {
    private final Logger logger = Logger.getInstance();
    private final PlayerRepository playerRepository = PlayerRepository.getInstance();
    public Player createPlayer(PlayerCreateRequest playerCreateRequest)
    {
        logger.info("Creating new player: " + playerCreateRequest);

        validatePlayerCreateRequest(playerCreateRequest);
        Player player = new Player(playerCreateRequest.playerName, playerCreateRequest.dateOfBirth, playerCreateRequest.nationality, playerCreateRequest.battingStyle, playerCreateRequest.bowlingStyle);
        player.setActive(true);
        Player savedPlayer = playerRepository.save(player);
        logger.info("Successfully created player with ID: " + savedPlayer.getPlayerId());
        return savedPlayer;
    }

    private Player getPlayerById(String playerId) {
        logger.debug("Fetch player with ID: " + playerId);
        return playerRepository.getById(playerId);
    }

    private Player updatePlayer(String playerId, PlayerUpdateRequest playerUpdateRequest)
    {
        logger.info("Updating player with id: " + playerId);
        Player existingPlayer = playerRepository.getById(playerId);
        if(playerUpdateRequest.playerName != null && isPropertyChanged(existingPlayer.getPlayerName(), playerUpdateRequest.playerName))
        {
            existingPlayer.setPlayerName(playerUpdateRequest.playerName);
        }
        if(playerUpdateRequest.dateOfBirth != null && isPropertyChanged(existingPlayer.getDateOfBirth(), playerUpdateRequest.dateOfBirth))
        {
            existingPlayer.setDateOfBirth(playerUpdateRequest.dateOfBirth);
        }
        if(playerUpdateRequest.nationality != null && isPropertyChanged(existingPlayer.getNationality(), playerUpdateRequest.nationality))
        {
            existingPlayer.setNationality(playerUpdateRequest.nationality);
        }
        if(playerUpdateRequest.battingStyle != null && isPropertyChanged(existingPlayer.getBattingStyle(), playerUpdateRequest.battingStyle))
        {
            existingPlayer.setBattingStyle(playerUpdateRequest.battingStyle);
        }
        if(playerUpdateRequest.bowlingStyle != null && isPropertyChanged(existingPlayer.getBowlingStyle(), playerUpdateRequest.bowlingStyle))
        {
            existingPlayer.setBowlingStyle(playerUpdateRequest.bowlingStyle);
        }
        if(playerUpdateRequest.isActive && isPropertyChanged(existingPlayer.isActive(), playerUpdateRequest.isActive))
        {
            existingPlayer.setActive(playerUpdateRequest.isActive);
        }
        Player updatedPlayer = playerRepository.update(existingPlayer);
        logger.info("Successfully updated player with ID: " + playerId);
        return updatedPlayer;
    }

    private void deletePlayer(String playerId)
    {
        logger.info("Deleting player with id: " + playerId);
        Player existingPlayer = playerRepository.getById(playerId);
        //TODO - remove all references of this deleted player from the Teams also
        //{...}
        playerRepository.deleteById(playerId);
        logger.info("Successfully deleted match with ID: " + playerId);
    }

    public List<Player> findPlayers(PlayerSearchRequest playerSearchRequest)
    {
        logger.debug("Finding players with filters");
        return playerRepository.findAll().stream().filter((player) -> {
            boolean playerNameFilter = playerSearchRequest.playerName == null || (player.getPlayerName() != null && player.getPlayerName().equalsIgnoreCase(playerSearchRequest.playerName));
            boolean dateOfBirthFilter = playerSearchRequest.dateOfBirth == null || (player.getDateOfBirth() != null && player.getDateOfBirth().isEqual(playerSearchRequest.dateOfBirth));
            boolean nationalityFilter = playerSearchRequest.nationality == null || (player.getNationality() != null && player.getNationality().equalsIgnoreCase(playerSearchRequest.nationality));
            boolean battingStyleFilter = playerSearchRequest.battingStyle == null || (player.getBattingStyle() != null && player.getBattingStyle().equals(playerSearchRequest.battingStyle));
            boolean bowlingStyleFilter = playerSearchRequest.bowlingStyle == null || (player.getBowlingStyle() != null && player.getBowlingStyle().equals(playerSearchRequest.bowlingStyle));
            boolean isActiveFilter = !playerSearchRequest.isActive || player.isActive();

            return playerNameFilter && dateOfBirthFilter && nationalityFilter && battingStyleFilter && bowlingStyleFilter && isActiveFilter;
        }).toList();
    }

    private boolean isPropertyChanged(Object previous, Object existing)
    {
        return !previous.equals(existing);
    }

    private void validatePlayerCreateRequest(PlayerCreateRequest playerCreateRequest)
    {
        validateNotNull(playerCreateRequest.playerName, "Player name");
        validateNotNull(playerCreateRequest.dateOfBirth, "Date of birth");
        validateNotNull(playerCreateRequest.nationality, "Nationality");
        validateNotNull(playerCreateRequest.battingStyle, "Batting style");
        validateNotNull(playerCreateRequest.bowlingStyle, "Bowling style");
    }

    private void validateNotNull(Object fieldValue, String fieldName)
    {
        if(fieldValue == null)
        {
            throw new BusinessValidationException(String.format("%s cannot be empty", fieldName));
        }
    }
}
