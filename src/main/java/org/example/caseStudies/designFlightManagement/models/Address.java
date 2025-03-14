package org.example.caseStudies.designFlightManagement.models;

public class Address {
    private String line1;
    private String line2;
    private String zipCode;
    private String latitude;
    private String longitude;

    public Address(String line1, String line2, String zipCode, String latitute, String longitude) {
        this.line1 = line1;
        this.line2 = line2;
        this.zipCode = zipCode;
        this.latitude = latitute;
        this.longitude = longitude;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
