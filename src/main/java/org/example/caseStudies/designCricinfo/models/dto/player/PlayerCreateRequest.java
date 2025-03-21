package org.example.caseStudies.designCricinfo.models.dto.player;

import org.example.caseStudies.designCricinfo.models.enums.BattingStyle;
import org.example.caseStudies.designCricinfo.models.enums.BowlingStyle;

import java.time.LocalDate;

public class PlayerCreateRequest {
    public String playerName;
    public LocalDate dateOfBirth;
    public String nationality;
    public BattingStyle battingStyle;
    public BowlingStyle bowlingStyle;

    public PlayerCreateRequest(String playerName, LocalDate dateOfBirth, String nationality, BattingStyle battingStyle, BowlingStyle bowlingStyle) {
        this.playerName = playerName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
    }
}
