package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
    private static int counter = 101;

    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTill;
    private Location location;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;
    private Location pickupLocation;
    private Location dropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;

    public Reservation(int reservationId, User user, Vehicle vehicle, Date bookingDate, Date dateBookedFrom, Date dateBookedTill, Location location, LocalDateTime fromTime, LocalDateTime toTime, Location pickupLocation, Location dropLocation, ReservationType reservationType, ReservationStatus reservationStatus) {
        this.reservationId = String.valueOf(counter++);
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTill = dateBookedTill;
        this.location = location;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.reservationType = ReservationType.DAILY;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDateBookedFrom() {
        return dateBookedFrom;
    }

    public void setDateBookedFrom(Date dateBookedFrom) {
        this.dateBookedFrom = dateBookedFrom;
    }

    public Date getDateBookedTill() {
        return dateBookedTill;
    }

    public void setDateBookedTill(Date dateBookedTill) {
        this.dateBookedTill = dateBookedTill;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", bookingDate=" + bookingDate +
                ", dateBookedFrom=" + dateBookedFrom +
                ", dateBookedTill=" + dateBookedTill +
                ", location=" + location +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                ", pickupLocation=" + pickupLocation +
                ", dropLocation=" + dropLocation +
                ", reservationType=" + reservationType +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
