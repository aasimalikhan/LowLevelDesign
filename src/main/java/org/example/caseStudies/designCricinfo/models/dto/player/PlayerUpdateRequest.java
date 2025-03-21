package org.example.caseStudies.designCricinfo.models.dto.player;

import org.example.caseStudies.designCricinfo.models.enums.BattingStyle;
import org.example.caseStudies.designCricinfo.models.enums.BowlingStyle;

import java.time.LocalDate;

public class PlayerUpdateRequest {
    public String playerName;
    public LocalDate dateOfBirth;
    public String nationality;
    public BattingStyle battingStyle;
    public BowlingStyle bowlingStyle;
    public boolean isActive;
}
