package org.example.designScenarios.designFlightManagement.commands;

import org.example.designScenarios.designFlightManagement.exceptions.AirportNotFoundException;
import org.example.designScenarios.designFlightManagement.exceptions.FlightNotFoundException;
import org.example.designScenarios.designFlightManagement.factory.PricingStrategyFactory;
import org.example.designScenarios.designFlightManagement.managers.FlightManager;
import org.example.designScenarios.designFlightManagement.models.*;
import org.example.designScenarios.designFlightManagement.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.Map;

public class BookFlightCommand implements Command<FlightInstance, Reservation> {
    private FlightInstance flightInstance;
    private User initiator;
    private Map<Passenger, Seat> passengerSeatMap;

    private void validateFlight() throws AirportNotFoundException, FlightNotFoundException {
        FlightManager.getInstance().validateFlight(flightInstance);
    }

    private double calculateAmount()
    {
        PricingStrategy pricingStrategy = PricingStrategyFactory.getPricingStrategy(PricingStrategyType.STATIC);
        return passengerSeatMap.values().stream().mapToDouble((seat) -> {
            assert pricingStrategy != null;
            return pricingStrategy.getAmount(flightInstance, seat);
        }).sum();
    }

    private Reservation getIntermediaryReservationObject()
    {
        Payment payment = new Payment(PaymentStatus.PENDING, calculateAmount());
        return new Reservation("1122", passengerSeatMap, payment, initiator, LocalDateTime.now());
    }
    @Override
    public synchronized Reservation execute() throws Exception {
        validateFlight();
        Reservation intermediateReservation = getIntermediaryReservationObject();
        CreateReservationCommand createReservationCommand = new CreateReservationCommand(intermediateReservation);
        return createReservationCommand.execute();
    }
}
