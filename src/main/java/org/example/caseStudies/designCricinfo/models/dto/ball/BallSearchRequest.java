package org.example.caseStudies.designCricinfo.models.dto.ball;

import org.example.caseStudies.designCricinfo.models.enums.BallResult;
import org.example.caseStudies.designCricinfo.models.enums.ExtraType;
import org.example.caseStudies.designCricinfo.models.enums.WicketType;

public class BallSearchRequest {
    public String overId;
    public Integer ballNumber;
    public String bowlerId;
    public String batsmanId;
    public Boolean isWicket;
    public WicketType wicketType;
    public ExtraType extraType;
    public BallResult ballResult;
}
