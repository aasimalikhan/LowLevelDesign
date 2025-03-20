package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Player;
import org.example.caseStudies.designCricinfo.models.enums.BattingStyle;
import org.example.caseStudies.designCricinfo.models.enums.BowlingStyle;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerRepository {
    private final Map<String, Player> playerStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static PlayerRepository playerRepository;

    public static PlayerRepository getInstance()
    {
        if(playerRepository == null)
        {
            synchronized (PlayerRepository.class)
            {
                playerRepository = new PlayerRepository();
            }
        }
        return playerRepository;
    }

    private PlayerRepository()
    {
        this.playerStore = new HashMap<>();
    }

    public Player save(Player player) {
        if(player.getPlayerId() != null && playerStore.containsKey(player.getPlayerId()))
        {
            throw new DuplicateEntityException("Player", player.getPlayerId());
        }

        if(player.getPlayerId() == null)
        {
            String id = "PLAYER-" + idCounter.incrementAndGet();
            player.setPlayerId(id);
        }

        playerStore.put(player.getPlayerId(), player);
        return player;
    }

    public Optional<Player> findById(String playerId) {
        return Optional.ofNullable(playerStore.get(playerId));
    }

    public Player getById(String playerId)
    {
        return findById(playerId).orElseThrow(() -> new EntityNotFoundException("Player", playerId));
    }

    public Player update(Player player)
    {
        if(player.getPlayerId() == null || !playerStore.containsKey(player.getPlayerId()))
        {
            throw new EntityNotFoundException("Player", player.getPlayerId() == null ? "null" : player.getPlayerId());
        }
        playerStore.put(player.getPlayerId(), player);
        return player;
    }

    public void deleteById(String playerId) {
        if(!playerStore.containsKey(playerId)) {
            throw new EntityNotFoundException("Player", playerId);
        }
        playerStore.remove(playerId);
    }

    public boolean existsById(String playerId) {
        return playerStore.containsKey(playerId);
    }

    public List<Player> findAll() {
        return new ArrayList<>(playerStore.values());
    }

    public List<Player> findByNationality(String nationality) {
        return playerStore.values().stream().filter((player) -> player.getNationality().equals(nationality)).toList();
    }

    public long countByNationality(String nationality) {
        return playerStore.values().stream().filter((player) -> player.getNationality().equals(nationality)).count();
    }

    public List<Player> findByBattingStyle(BattingStyle battingStyle)
    {
        return playerStore.values().stream().filter((player) -> player.getBattingStyle().equals(battingStyle)).toList();
    }

    public List<Player> findByBowlingStyle(BowlingStyle bowlingStyle)
    {
        return playerStore.values().stream().filter((player) -> player.getBowlingStyle().equals(bowlingStyle)).toList();
    }

}
