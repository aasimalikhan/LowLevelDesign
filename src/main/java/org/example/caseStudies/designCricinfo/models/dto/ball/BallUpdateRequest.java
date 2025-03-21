package org.example.caseStudies.designCricinfo.models.dto.ball;

import org.example.caseStudies.designCricinfo.models.enums.BallResult;
import org.example.caseStudies.designCricinfo.models.enums.ExtraType;
import org.example.caseStudies.designCricinfo.models.enums.WicketType;

public class BallUpdateRequest {
    public Integer runsScored;
    public Integer extraRuns;
    public ExtraType extraType;
    public Boolean isWicket;
    public WicketType wicketType;
    public String fielderId;
    public BallResult ballResult;
}
