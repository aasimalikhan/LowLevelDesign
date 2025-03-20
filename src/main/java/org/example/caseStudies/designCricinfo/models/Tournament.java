package org.example.caseStudies.designCricinfo.models;

import org.example.caseStudies.designCricinfo.models.enums.TournamentFormat;
import org.example.caseStudies.designCricinfo.models.enums.TournamentStatus;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;

public class Tournament {
    private String tournamentId;
    private String tournamentName;
    private TournamentFormat format;
    private LinkedHashSet<String> teamIds;
    private LinkedHashSet<String> matchIds;
    private LocalDate startDate;
    private LocalDate endDate;
    private TournamentStatus status;

    public Tournament(String tournamentId, String tournamentName, TournamentFormat format) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.format = format;
        this.status = TournamentStatus.UPCOMING;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public TournamentFormat getFormat() {
        return format;
    }

    public void setFormat(TournamentFormat format) {
        this.format = format;
    }

    public List<String> getTeamIds() {
        return teamIds.stream().toList();
    }

    public void setTeamIds(List<String> teamIds) {
        this.teamIds = new LinkedHashSet<>(teamIds);
    }

    public List<String> getMatchIds() {
        return matchIds.stream().toList();
    }

    public void setMatchIds(List<String> matchIds) {
        this.matchIds = new LinkedHashSet<>(matchIds);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TournamentStatus getStatus() {
        return status;
    }

    public void setStatus(TournamentStatus status) {
        this.status = status;
    }
}
