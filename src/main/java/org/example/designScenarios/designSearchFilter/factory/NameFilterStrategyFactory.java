package org.example.designScenarios.designSearchFilter.factory;

import org.example.designScenarios.designSearchFilter.strategy.namefilter.NameFilterStrategy;
import org.example.designScenarios.designSearchFilter.strategy.namefilter.NameWindowFilterStrategy;

public class NameFilterStrategyFactory {
    public static NameFilterStrategy getNameFilterStrategy()
    {
        return new NameWindowFilterStrategy();
    }
}
