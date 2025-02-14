package org.example.designScenarios.designFlightManagement.factory;

import org.example.designScenarios.designFlightManagement.models.PricingStrategyType;
import org.example.designScenarios.designFlightManagement.strategy.pricing.PricingStrategy;
import org.example.designScenarios.designFlightManagement.strategy.pricing.StandardPricingStrategy;

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
