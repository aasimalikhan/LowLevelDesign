package org.example.solidprinciples.facadeDesignPattern.scenario2;

public class OrderFacade {
    ProductDAO productDAO;
    Invoice invoice;
    Payment payment;
    SendNotification sendNotification;
    public OrderFacade() {
        productDAO = new ProductDAO();
        invoice = new Invoice();
        payment = new Payment();
        sendNotification = new SendNotification();
    }

    public void createOrder() {
        Product product = productDAO.getProduct(121);
        payment.makePayment();
        invoice.generateInvoice();
        sendNotification.sendNotification();
    }
}
