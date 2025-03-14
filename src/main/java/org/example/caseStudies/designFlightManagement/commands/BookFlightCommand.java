package org.example.caseStudies.designFlightManagement.commands;

import org.example.caseStudies.designFlightManagement.exceptions.AirportNotFoundException;
import org.example.caseStudies.designFlightManagement.exceptions.FlightNotFoundException;
import org.example.caseStudies.designFlightManagement.factory.PricingStrategyFactory;
import org.example.caseStudies.designFlightManagement.managers.FlightManager;
import org.example.caseStudies.designFlightManagement.models.*;
import org.example.caseStudies.designFlightManagement.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.Map;

public class BookFlightCommand implements Command<FlightInstance, Reservation> {
    private FlightInstance flightInstance;
    private User initiator;
    private Map<Passenger, Seat> passengerSeatMap;

    public BookFlightCommand(FlightInstance flightInstance, User initiator, Map<Passenger, Seat> passengerSeatMap)
    {
        this.flightInstance = flightInstance;
        this.initiator = initiator;
        this.passengerSeatMap = passengerSeatMap;
    }

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
        payment.setPaymentType(PaymentType.DEBIT_CARD);
        Reservation reservation =  new Reservation("1122", passengerSeatMap, payment, initiator, LocalDateTime.now());
        reservation.setFlight(flightInstance);
        return reservation;
    }

    @Override
    public synchronized Reservation execute() throws Exception {
        validateFlight();
        Reservation intermediateReservation = getIntermediaryReservationObject();
        CreateReservationCommand createReservationCommand = new CreateReservationCommand(intermediateReservation);
        return createReservationCommand.execute();
    }
}
