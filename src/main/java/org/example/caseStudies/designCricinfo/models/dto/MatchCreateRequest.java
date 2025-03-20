package org.example.caseStudies.designCricinfo.models.dto;

import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;

import java.util.LinkedHashSet;
import java.util.List;

public class MatchCreateRequest {
    public String tournamentId;
    public List<String> teamIds;
    public MatchFormat matchFormat;

    @Override
    public String toString() {
        return "REQUEST - MatchCreateRequest { \n " +
                " tournamentId: " + tournamentId + "\n " +
                " teamIds: " + teamIds + " \n " +
                " matchFormat: " + matchFormat + "\n " +
                "}";
    }
}
