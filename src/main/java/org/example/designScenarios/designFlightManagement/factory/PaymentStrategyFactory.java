package org.example.designScenarios.designFlightManagement.factory;

import org.example.designScenarios.designFlightManagement.exceptions.UnsupportedPaymentTypeException;
import org.example.designScenarios.designFlightManagement.models.PaymentType;
import org.example.designScenarios.designFlightManagement.strategy.payment.DebitCardPaymentStrategy;
import org.example.designScenarios.designFlightManagement.strategy.payment.PaymentStrategy;
import org.example.designScenarios.designFlightManagement.strategy.payment.UPIPaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {
    private static Map<PaymentType, PaymentStrategy> paymentTypeParkingStrategyMap;

    static {
        paymentTypeParkingStrategyMap = new HashMap<>();
        paymentTypeParkingStrategyMap.put(PaymentType.UPI, new UPIPaymentStrategy());
        paymentTypeParkingStrategyMap.put(PaymentType.DEBIT_CARD, new DebitCardPaymentStrategy());
    }

    public static PaymentStrategy getPaymentStrategy(PaymentType paymentType) throws Exception {
        PaymentStrategy strategy = paymentTypeParkingStrategyMap.get(paymentType);
        if (strategy == null) {
            throw new UnsupportedPaymentTypeException("Payment type not supported: " + paymentType);
        }
        return strategy;
    }
}
