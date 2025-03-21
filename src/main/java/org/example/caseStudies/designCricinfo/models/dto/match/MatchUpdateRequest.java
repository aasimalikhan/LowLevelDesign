package org.example.caseStudies.designCricinfo.models.dto.match;

import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;
import org.example.caseStudies.designCricinfo.models.enums.TossDecision;

import java.time.LocalDateTime;
import java.util.List;

public class MatchUpdateRequest {
    public String tournamentId;
    public List<String> teamIds;
    public MatchFormat matchFormat;
    public List<String> inningsIds;
    public String venueId;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public String tossWinnerTeamId;
    public TossDecision tossDecision;

//    @Override
//    public String toString() {
//        return "REQUEST - MatchCreateRequest { \n " +
//                " tournamentId: " + tournamentId + "\n " +
//                " teamIds: " + teamIds + " \n " +
//                " matchFormat: " + matchFormat + "\n " +
//                "}";
//    }
}
