package org.example.caseStudies.designCricinfo.models.dto.tournament;

import org.example.caseStudies.designCricinfo.models.enums.TournamentStatus;

import java.time.LocalDate;
import java.util.List;

public class TournamentUpdateRequest {
    public String tournamentName;
    public List<String> teamIds;
    public LocalDate startDate;
    public LocalDate endDate;
    public TournamentStatus status;
}
