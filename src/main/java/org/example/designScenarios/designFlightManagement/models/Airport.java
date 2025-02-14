package org.example.designScenarios.designFlightManagement.models;

public class Airport {
    private static long idCounter = 10001;
    private String id;
    private String code;
    private String name;
    private String country;
    private Address address;

    public Airport(String code, String name, String country) {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.code = code;
        this.country = country;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", address=" + address +
                '}';
    }
}
