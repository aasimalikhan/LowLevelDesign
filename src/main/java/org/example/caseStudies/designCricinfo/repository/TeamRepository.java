package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Team;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TeamRepository {
    private final Map<String, Team> teamStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static TeamRepository teamRepository;

    public static TeamRepository getInstance()
    {
        if(teamRepository == null)
        {
            synchronized (TeamRepository.class)
            {
                teamRepository = new TeamRepository();
            }
        }
        return teamRepository;
    }

    private TeamRepository()
    {
        this.teamStore = new HashMap<>();
    }

    public Team save(Team team)
    {
        if(team.getTeamId() != null || !teamStore.containsKey(team.getTeamId()))
        {
            throw new DuplicateEntityException("Team", team.getTeamId());
        }

        if(team.getTeamId() == null)
        {
            String id = "TEAM-" + idCounter.incrementAndGet();
            team.setTeamId(id);
        }

        teamStore.put(team.getTeamId(), team);
        return team;
    }

    public Optional<Team> findById(String teamId) {
        return Optional.ofNullable(teamStore.get(teamId));
    }

    public Team getById(String teamId) {
        return findById(teamId).orElseThrow(() -> new EntityNotFoundException("Team", teamId));
    }

    public Team update(Team team)
    {
        if(team.getTeamId() == null || !teamStore.containsKey(team.getTeamId()))
        {
            throw new EntityNotFoundException("Team", team.getTeamId() == null ? "null" : team.getTeamId());
        }
        teamStore.put(team.getTeamId(), team);
        return team;
    }

    public void deleteById(String teamId) {
        if(!teamStore.containsKey(teamId))
        {
            throw new EntityNotFoundException("Team", teamId);
        }
        teamStore.remove(teamId);
    }

    public List<Team> findAll() {
        return new ArrayList<>(teamStore.values());
    }

    public boolean existsById(String teamId) {
        return teamStore.containsKey(teamId);
    }
}
