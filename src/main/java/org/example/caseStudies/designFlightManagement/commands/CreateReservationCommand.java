package org.example.caseStudies.designFlightManagement.commands;

import org.example.caseStudies.designFlightManagement.exceptions.ReservationException;
import org.example.caseStudies.designFlightManagement.exceptions.SeatNotAvailableException;
import org.example.caseStudies.designFlightManagement.factory.PaymentStrategyFactory;
import org.example.caseStudies.designFlightManagement.managers.ReservationManager;
import org.example.caseStudies.designFlightManagement.managers.SeatManager;
import org.example.caseStudies.designFlightManagement.models.FlightInstance;
import org.example.caseStudies.designFlightManagement.models.PaymentStatus;
import org.example.caseStudies.designFlightManagement.models.Reservation;
import org.example.caseStudies.designFlightManagement.strategy.payment.PaymentStrategy;

public class CreateReservationCommand implements Command<Reservation, Reservation> {
    private final Reservation reservation;

    public CreateReservationCommand(Reservation reservation)
    {
        this.reservation = reservation;
    }

    private void validateReservation() throws ReservationException {
        if(reservation == null || reservation.getFlight() == null)
        {
            throw new ReservationException("Invalid reservation data");
        }
    }

    private void checkSeatAvailability() throws SeatNotAvailableException {
        SeatManager.getInstance().isGroupSeatAvailable(reservation.getFlight(), reservation.getPassengerSeatMap().values().stream().toList());
    }

    private void processPayment() throws Exception {
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(reservation.getPayment().getPaymentType());
        boolean paymentSuccessful = paymentStrategy.pay(reservation.getPayment().getAmount());

        if (!paymentSuccessful) {
            throw new ReservationException("Payment failed");
        }
        reservation.getPayment().setPaymentStatus(PaymentStatus.COMPLETED);
    }

    private void updateSeats()
    {
        FlightInstance flightInstance = reservation.getFlight();
        if (flightInstance == null) {
            throw new IllegalStateException("Flight instance not found for reservation");
        }
        reservation.getPassengerSeatMap().values()
                .forEach(seat -> flightInstance.bookSeat(seat.getId()));
    }

    private Reservation saveReservation()
    {
        return ReservationManager.getInstance().addReservation(reservation);
    }

    @Override
    public synchronized Reservation execute() throws Exception {
        validateReservation();
        checkSeatAvailability();
        processPayment();
        updateSeats();
        return saveReservation();
    }
}
