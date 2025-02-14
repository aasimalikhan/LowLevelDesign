package org.example.designScenarios.designFlightManagement.models;

public class Seat {
    private static long idCounter = 10001;
    private String id;
    private String code;
    private SeatType type;
    private SeatClass classType;

    public Seat(String code, SeatType type, SeatClass classType) {
        this.id = String.valueOf(idCounter++);
        this.code = code;
        this.type = type;
        this.classType = classType;
    }

    public String getId()
    {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public SeatClass getClassType() {
        return classType;
    }

    public void setClassType(SeatClass classType) {
        this.classType = classType;
    }
}
