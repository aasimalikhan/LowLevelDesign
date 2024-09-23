package org.example.solidprinciples.singleResponsibilityPrinciple.goodCode;

public class InvoiceDao {
    Invoice invoice;
    public InvoiceDao(Invoice invoice)
    {
        this.invoice = invoice;
    }
    public void saveToDb()
    {
        //save to database
    }
}
