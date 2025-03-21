package org.example.caseStudies.designCricinfo.models;

import org.example.caseStudies.designCricinfo.models.enums.BallResult;
import org.example.caseStudies.designCricinfo.models.enums.ExtraType;
import org.example.caseStudies.designCricinfo.models.enums.WicketType;

public class Ball {
    private String ballId;
    private String overId;
    private Integer ballNumber;
    private String bowlerId;
    private String batsmanId;
    private String nonStrikerId;
    private Integer runsScored;
    private Integer extraRuns;
    private ExtraType extraType;
    private boolean isWicket;
    private WicketType wicketType;
    private String fielderId;
    private BallResult ballResult;

    public Ball(String overId, int ballNumber, String bowlerId, String batsmanId, String nonStrikerId, int runsScored, BallResult ballResult) {
        this.overId = overId;
        this.ballNumber = ballNumber;
        this.bowlerId = bowlerId;
        this.batsmanId = batsmanId;
        this.nonStrikerId = nonStrikerId;
        this.runsScored = runsScored;
        this.ballResult = ballResult;
    }

    public String getBallId() {
        return ballId;
    }

    public void setBallId(String ballId) {
        this.ballId = ballId;
    }

    public String getOverId() {
        return overId;
    }

    public void setOverId(String overId) {
        this.overId = overId;
    }

    public Integer getBallNumber() {
        return ballNumber;
    }

    public void setBallNumber(Integer ballNumber) {
        this.ballNumber = ballNumber;
    }

    public String getBowlerId() {
        return bowlerId;
    }

    public void setBowlerId(String bowlerId) {
        this.bowlerId = bowlerId;
    }

    public String getBatsmanId() {
        return batsmanId;
    }

    public void setBatsmanId(String batsmanId) {
        this.batsmanId = batsmanId;
    }

    public String getNonStrikerId() {
        return nonStrikerId;
    }

    public void setNonStrikerId(String nonStrikerId) {
        this.nonStrikerId = nonStrikerId;
    }

    public Integer getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(Integer runsScored) {
        this.runsScored = runsScored;
    }

    public Integer getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(Integer extraRuns) {
        this.extraRuns = extraRuns;
    }

    public ExtraType getExtraType() {
        return extraType;
    }

    public void setExtraType(ExtraType extraType) {
        this.extraType = extraType;
    }

    public boolean isWicket() {
        return isWicket;
    }

    public void setWicket(boolean wicket) {
        isWicket = wicket;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public String getFielderId() {
        return fielderId;
    }

    public void setFielderId(String fielderId) {
        this.fielderId = fielderId;
    }

    public BallResult getBallResult() {
        return ballResult;
    }

    public void setBallResult(BallResult ballResult) {
        this.ballResult = ballResult;
    }
}
