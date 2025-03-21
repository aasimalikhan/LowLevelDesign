package org.example.caseStudies.designCricinfo.factory;

import org.example.caseStudies.designCricinfo.models.Match;
import org.example.caseStudies.designCricinfo.models.enums.MatchFormat;

public class MatchFormatDetailsFactory {
    public static int getInningsOvers(Match match)
    {
        return switch (match.getFormat())
        {
            case MatchFormat.T10 -> 10;
            case MatchFormat.T20 -> 20;
            case MatchFormat.ONE_DAY -> 50;
            case CUSTOM -> {
                Integer customOvers = match.getCustomOvers();
                if(customOvers == null)
                {
                    throw new IllegalStateException("Custom match format requires custom overs to be set");
                }
                yield customOvers;
            }
        };
    }
}
