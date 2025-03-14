package org.example.caseStudies.designParkingLot.models;

public abstract class ParkingSpot {
    private static int idCounter = 1;
    private long id;
    private boolean isEmpty;
    private Vehicle vehicle;
    protected double hourlyRate;
    protected double minutelyRate;

    public ParkingSpot()
    {
        this.id = idCounter++;
        this.isEmpty = true;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getHourlyRate();

    public abstract double getMinutelyRate();

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", isEmpty=" + isEmpty +
                ", vehicle=" + (vehicle != null ? vehicle : "None") +  // If vehicle is null, print "None"
                ", hourlyRate=" + getHourlyRate() +
                ", minutelyRate=" + getMinutelyRate() +
                '}';
    }
}
