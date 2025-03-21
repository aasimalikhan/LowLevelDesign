package org.example.caseStudies.designCricinfo.factory;

import org.example.caseStudies.designCricinfo.models.enums.ExtraType;

public class ExtraRunsDetailsFactory {
    public static Integer getRunsForExtraDelivery(ExtraType extraType)
    {
        return switch (extraType) {
            case NONE -> 0;
            case WIDE -> 1;
            case NO_BALL -> 1;
            case BYE -> 0;
            case LEG_BYE -> 0;
        };
    }
}
