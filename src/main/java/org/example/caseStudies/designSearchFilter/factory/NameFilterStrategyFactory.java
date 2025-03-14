package org.example.caseStudies.designSearchFilter.factory;

import org.example.caseStudies.designSearchFilter.strategy.namefilter.NameFilterStrategy;
import org.example.caseStudies.designSearchFilter.strategy.namefilter.NameWindowFilterStrategy;

public class NameFilterStrategyFactory {
    public static NameFilterStrategy getNameFilterStrategy()
    {
        return new NameWindowFilterStrategy();
    }
}
