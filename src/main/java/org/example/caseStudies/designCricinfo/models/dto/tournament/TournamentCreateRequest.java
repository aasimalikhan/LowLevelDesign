package org.example.caseStudies.designCricinfo.models.dto.tournament;

import org.example.caseStudies.designCricinfo.models.enums.TournamentFormat;

import java.time.LocalDate;
import java.util.List;

public class TournamentCreateRequest {
    public String tournamentName;
    public TournamentFormat format;
    public List<String> teamIds;
}
