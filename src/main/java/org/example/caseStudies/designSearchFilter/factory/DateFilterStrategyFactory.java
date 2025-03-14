package org.example.caseStudies.designSearchFilter.factory;

import org.example.caseStudies.designSearchFilter.strategy.datefilter.DateFilterStrategy;
import org.example.caseStudies.designSearchFilter.strategy.datefilter.RangeDateFilterStrategy;

public class DateFilterStrategyFactory {
    public static DateFilterStrategy getDateFilterStrategy()
    {
        return new RangeDateFilterStrategy();
    }
}
