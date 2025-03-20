package org.example.caseStudies.designCricinfo.models;

import org.example.caseStudies.designCricinfo.models.enums.InningsStatus;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Innings {
    private String inningsId;
    private String matchId;
    private int inningsNumber;
    private String battingTeamId;
    private String bowlingTeamId;
    private LinkedHashSet<String> overIds;
    private InningsStatus inningsStatus;

    public Innings(String inningsId, String matchId, int inningsNumber, String battingTeamId, String bowlingTeamId) {
        this.inningsId = inningsId;
        this.matchId = matchId;
        this.inningsNumber = inningsNumber;
        this.battingTeamId = battingTeamId;
        this.bowlingTeamId = bowlingTeamId;
        this.overIds = new LinkedHashSet<>();
        this.inningsStatus = InningsStatus.DECLARED;
    }

    public String getInningsId() {
        return inningsId;
    }

    public void setInningsId(String inningsId) {
        this.inningsId = inningsId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getInningsNumber() {
        return inningsNumber;
    }

    public void setInningsNumber(int inningsNumber) {
        this.inningsNumber = inningsNumber;
    }

    public String getBattingTeamId() {
        return battingTeamId;
    }

    public void setBattingTeamId(String battingTeamId) {
        this.battingTeamId = battingTeamId;
    }

    public String getBowlingTeamId() {
        return bowlingTeamId;
    }

    public void setBowlingTeamId(String bowlingTeamId) {
        this.bowlingTeamId = bowlingTeamId;
    }

    public List<String> getOverIds() {
        return overIds.stream().toList();
    }

    public void setOverIds(List<String> overIds) {
        this.overIds = new LinkedHashSet<>(overIds);
    }

    public void addOverId(String overId) {
        this.overIds.add(overId);
    }

    public void removeOverId(String overId) {
        this.overIds.remove(overId);
    }

    public InningsStatus getInningsStatus() {
        return inningsStatus;
    }

    public void setInningsStatus(InningsStatus inningsStatus) {
        this.inningsStatus = inningsStatus;
    }
}
