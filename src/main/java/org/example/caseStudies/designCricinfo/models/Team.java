package org.example.caseStudies.designCricinfo.models;

import java.util.LinkedHashSet;
import java.util.List;

public class Team {
    private String teamId;
    private String teamName;
    private LinkedHashSet<String> playerIdList;
    private String captainId;
    private String homeVenueId;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getPlayerIdList() {
        return playerIdList.stream().toList();
    }

    public void setPlayerIdList(List<String> playerIdList) {
        this.playerIdList = new LinkedHashSet<>(playerIdList);
    }

    public void addPlayerId(String playerId)
    {
        this.playerIdList.add(playerId);
    }

    public void removePlayerId(String playerId)
    {
        this.playerIdList.remove(playerId);
    }

    public String getCaptainId() {
        return captainId;
    }

    public void setCaptainId(String captainId) {
        this.captainId = captainId;
    }

    public String getHomeVenueId() {
        return homeVenueId;
    }

    public void setHomeVenueId(String homeVenueId) {
        this.homeVenueId = homeVenueId;
    }
}
