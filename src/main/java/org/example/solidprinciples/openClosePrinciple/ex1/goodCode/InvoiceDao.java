package org.example.solidprinciples.openClosePrinciple.ex1.goodCode;

import org.example.solidprinciples.openClosePrinciple.ex1.Invoice;

public interface InvoiceDao {
    public void save(Invoice invoice);
}
