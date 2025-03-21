package org.example.caseStudies.designCricinfo.models.dto.ball;

import org.example.caseStudies.designCricinfo.models.enums.BallResult;
import org.example.caseStudies.designCricinfo.models.enums.ExtraType;
import org.example.caseStudies.designCricinfo.models.enums.WicketType;

public class BallCreateRequest {
    public String overId;
    public int ballNumber;
    public String bowlerId;
    public String batsmanId;
    public String nonStrikerId;
    public Integer runsScored;
    public ExtraType extraType;
    public boolean isWicket;
    public WicketType wicketType;
    public String fielderId;
    public BallResult ballResult;


}
