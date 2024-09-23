package org.example.solidprinciples.openClosePrinciple.ex1.badCode;

import org.example.solidprinciples.openClosePrinciple.ex1.Invoice;

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
    public void saveToFile()
    {
        //save to file
    }
}
