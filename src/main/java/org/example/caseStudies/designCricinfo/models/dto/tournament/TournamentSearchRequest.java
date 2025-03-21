package org.example.caseStudies.designCricinfo.models.dto.tournament;

import org.example.caseStudies.designCricinfo.models.enums.TournamentFormat;
import org.example.caseStudies.designCricinfo.models.enums.TournamentStatus;

import java.time.LocalDate;

public class TournamentSearchRequest {
    public String tournamentName;
    public TournamentFormat format;
    public LocalDate startDate;
    public LocalDate endDate;
    public TournamentStatus status;
}
