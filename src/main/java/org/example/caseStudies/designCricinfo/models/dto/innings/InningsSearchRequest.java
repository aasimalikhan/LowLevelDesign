package org.example.caseStudies.designCricinfo.models.dto.innings;

import org.example.caseStudies.designCricinfo.models.enums.InningsStatus;

public class InningsSearchRequest {
    public String matchId;
    public Integer inningsNumber;
    public String battingTeamId;
    public String bowlingTeamId;
    public InningsStatus inningsStatus;
}
