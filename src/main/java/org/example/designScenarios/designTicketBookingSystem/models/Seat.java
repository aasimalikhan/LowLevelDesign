package org.example.designScenarios.designTicketBookingSystem.models;

import org.example.designScenarios.designTicketBookingSystem.enums.SeatCategory;

public class Seat {
    private static int idCounter = 101;
    private String id;
    private int row;
    private SeatCategory category;

    public Seat(int row, SeatCategory seatCategory)
    {
        this.id = String.valueOf(idCounter++);
        this.row = row;
        this.category = seatCategory;
    }

    public Seat() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public void setCategory(SeatCategory category) {
        this.category = category;
    }
}
