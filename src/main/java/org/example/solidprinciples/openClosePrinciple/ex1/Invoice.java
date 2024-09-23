package org.example.solidprinciples.openClosePrinciple.ex1;

import org.example.solidprinciples.singleResponsibilityPrinciple.badCode.Marker;

public class Invoice {
    private Marker marker;
    private int quantity;
    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
}
