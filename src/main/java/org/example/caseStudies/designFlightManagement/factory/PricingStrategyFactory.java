package org.example.caseStudies.designFlightManagement.factory;

import org.example.caseStudies.designFlightManagement.models.PricingStrategyType;
import org.example.caseStudies.designFlightManagement.strategy.pricing.PricingStrategy;
import org.example.caseStudies.designFlightManagement.strategy.pricing.StandardPricingStrategy;

public class PricingStrategyFactory {
    public static PricingStrategy getPricingStrategy(PricingStrategyType pricingStrategyType)
    {
        return switch(pricingStrategyType)
        {
            case STATIC -> new StandardPricingStrategy();
            case DYNAMIC -> null;
        };
    }
}
