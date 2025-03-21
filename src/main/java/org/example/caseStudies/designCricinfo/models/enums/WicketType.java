package org.example.caseStudies.designCricinfo.models.enums;

public enum WicketType {
    BOWLED,
    CAUGHT,
    RUN_OUT,
    STUMPED,
    LBW,
    HIT_WICKET,
    TIMED_OUT,
    OBSTRUCTING,
    HANDLING,
    HIT_TWICE;

    public boolean requiredFielder() {
        return switch (this) {
            case CAUGHT, STUMPED, RUN_OUT -> true;
            case BOWLED, LBW, HIT_WICKET, TIMED_OUT, OBSTRUCTING, HANDLING, HIT_TWICE -> false;
            default -> false;
        };
    }
}
