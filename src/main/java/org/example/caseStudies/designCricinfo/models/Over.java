package org.example.caseStudies.designCricinfo.models;

import java.util.LinkedHashSet;
import java.util.List;

public class Over {
    private String overId;
    private String inningsId;
    private int overNumber;
    private String bowlerId;
    private LinkedHashSet<String> ballIds;
    private boolean isCompleted;

    public Over(String overId, String inningsId, int overNumber, String bowlerId) {
        this.overId = overId;
        this.inningsId = inningsId;
        this.overNumber = overNumber;
        this.bowlerId = bowlerId;
        this.isCompleted = false;
    }

    public String getOverId() {
        return overId;
    }

    public void setOverId(String overId) {
        this.overId = overId;
    }

    public String getInningsId() {
        return inningsId;
    }

    public void setInningsId(String inningsId) {
        this.inningsId = inningsId;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public void setOverNumber(int overNumber) {
        this.overNumber = overNumber;
    }

    public String getBowlerId() {
        return bowlerId;
    }

    public void setBowlerId(String bowlerId) {
        this.bowlerId = bowlerId;
    }

    public List<String> getBallIds() {
        return ballIds.stream().toList();
    }

    public void addBallId(String ballId) {
        ballIds.add(ballId);
    }

    public void removeBallId(String ballId) {
        ballIds.remove(ballId);
    }

    public void setBallIds(List<String> ballIds) {
        this.ballIds = new LinkedHashSet<>(ballIds);
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
