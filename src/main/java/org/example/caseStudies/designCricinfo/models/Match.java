package org.example.caseStudies.designCricinfo.models;

import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;
import org.example.caseStudies.designCricinfo.models.enums.MatchStatus;
import org.example.caseStudies.designCricinfo.models.enums.TossDecision;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;

public class Match {
    private String matchId;
    private String tournamentId;
    private LinkedHashSet<String> teamIds;
    private MatchFormat format;
    private LinkedHashSet<String> inningsIds;
    private MatchStatus matchStatus;
    private String venueId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String tossWinnerTeamId;
    private TossDecision tossDecision;
    private Integer customOvers;

    public Match(List<String> teamIds, MatchFormat format) {
        this.teamIds = new LinkedHashSet<>(teamIds);
        this.format = format;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public List<String> getTeamIds() {
        return teamIds.stream().toList();
    }

    public void setTeamIds(List<String> teamIds) {
        this.teamIds = new LinkedHashSet<>(teamIds);
    }

    public void addTeamId(String teamId) {
        this.teamIds.add(teamId);
    }

    public void removeTeamId(String teamId) {
        this.teamIds.remove(teamId);
    }

    public MatchFormat getFormat() {
        return format;
    }

    public void setFormat(MatchFormat format) {
        this.format = format;
    }

    public List<String> getInningsIds() {
        return inningsIds.stream().toList();
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public void setInningsIds(List<String> inningsIds) {
        this.inningsIds = new LinkedHashSet<>(inningsIds);
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTossWinnerTeamId() {
        return tossWinnerTeamId;
    }

    public void setTossWinnerTeamId(String tossWinnerTeamId) {
        this.tossWinnerTeamId = tossWinnerTeamId;
    }

    public TossDecision getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(TossDecision tossDecision) {
        this.tossDecision = tossDecision;
    }

    public Integer getCustomOvers() {
        if(this.getFormat().equals(MatchFormat.CUSTOM))
        {
            return this.customOvers;
        }
        throw new IllegalStateException("Cannot get custom overs for non-custom match format: " + this.getFormat());
    }

    public void setCustomOvers(Integer customOvers)
    {
        if(this.getFormat().equals(MatchFormat.CUSTOM))
        {
            this.customOvers = customOvers;
        }
        throw new IllegalStateException("Cannot update custom overs for non-custom match format: " + this.getFormat());
    }
}
