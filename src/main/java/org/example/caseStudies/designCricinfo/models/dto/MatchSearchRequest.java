package org.example.caseStudies.designCricinfo.models.dto;

import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;
import org.example.caseStudies.designCricinfo.models.enums.MatchStatus;

import java.time.LocalDateTime;

public class MatchSearchRequest {
    public String tournamentId;
    public MatchFormat format;
    public MatchStatus matchStatus;
    public String venueId;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
}
