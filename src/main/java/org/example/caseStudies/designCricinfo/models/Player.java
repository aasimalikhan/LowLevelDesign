package org.example.caseStudies.designCricinfo.models;

import org.example.caseStudies.designCricinfo.models.enums.BattingStyle;
import org.example.caseStudies.designCricinfo.models.enums.BowlingStyle;

import java.time.LocalDate;

public class Player {
    private String playerId;
    private String playerName;
    private LocalDate dateOfBirth;
    private String nationality;
    private BattingStyle battingStyle;
    private BowlingStyle bowlingStyle;
    private boolean isActive;

    public Player(String playerName, LocalDate dateOfBirth, String nationality, BattingStyle battingStyle, BowlingStyle bowlingStyle) {
        this.playerName = playerName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
    }

    public Player(String playerName, LocalDate dateOfBirth, String nationality, boolean isActive) {
        this.playerName = playerName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.isActive = isActive;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public BattingStyle getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(BattingStyle battingStyle) {
        this.battingStyle = battingStyle;
    }

    public BowlingStyle getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(BowlingStyle bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
