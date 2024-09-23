package org.example.solidprinciples.singleResponsibilityPrinciple.badCode;

public class Invoice {
    private Marker marker;
    private int quantity;
    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal() {
        int price = ((marker.price) * this.quantity);
        return price;
    }
    public void printInvoice() {
        //print Invoice
    }
    public void saveToDB()
    {
        //save data in database
    }
}
