package org.example.solidprinciples.openClosePrinciple.ex1.goodCode;

import org.example.solidprinciples.openClosePrinciple.ex1.Invoice;

public class FileInvoiceDao implements InvoiceDao{
    @Override
    public void save(Invoice invoice) {
        //save to file
    }
}
