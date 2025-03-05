package org.example.designScenarios.designSearchFilter.factory;

import org.example.designScenarios.designSearchFilter.strategy.datefilter.DateFilterStrategy;
import org.example.designScenarios.designSearchFilter.strategy.datefilter.RangeDateFilterStrategy;

public class DateFilterStrategyFactory {
    public static DateFilterStrategy getDateFilterStrategy()
    {
        return new RangeDateFilterStrategy();
    }
}
