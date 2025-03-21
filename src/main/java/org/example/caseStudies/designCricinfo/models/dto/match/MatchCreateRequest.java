package org.example.caseStudies.designCricinfo.models.dto.match;

import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;

import java.util.List;

public class MatchCreateRequest {
    public String tournamentId;
    public List<String> teamIds;
    public MatchFormat matchFormat;
    public Integer customOvers;

    public MatchCreateRequest(String tournamentId, List<String> teamIds, MatchFormat matchFormat)
    {
        this.tournamentId = tournamentId;
        this.teamIds = teamIds;
        this.matchFormat = matchFormat;
    }

    public MatchCreateRequest(String tournamentId, List<String> teamIds, MatchFormat matchFormat, Integer customOvers)
    {
        this.tournamentId = tournamentId;
        this.teamIds = teamIds;
        this.matchFormat = matchFormat;
        this.customOvers = customOvers;
    }

    @Override
    public String toString() {
        return "REQUEST - MatchCreateRequest { \n " +
                " tournamentId: " + tournamentId + "\n " +
                " teamIds: " + teamIds + " \n " +
                " matchFormat: " + matchFormat + "\n " +
                "}";
    }
}
