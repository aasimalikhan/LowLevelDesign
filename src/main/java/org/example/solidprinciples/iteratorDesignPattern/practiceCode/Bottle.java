package org.example.solidprinciples.iteratorDesignPattern.practiceCode;

public class Bottle {
    private String id;
    private double capacity;
    private String companyName;

    public Bottle(String id, double capacity, String companyName) {
        this.id = id;
        this.capacity = capacity;
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "id='" + id + '\'' +
                ", capacity=" + capacity +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
