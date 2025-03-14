package org.example.caseStudies.designInventoryManagementSystem;

import org.example.caseStudies.designInventoryManagementSystem.enums.OrderStatus;

import java.util.Map;

public class Order {
    private static int idCounter = 101;

    private String id;
    private User user;
    private Address deliveryAddress;
    private Map<String, Integer> productCountMap;
    private Warehouse fulfillingWarehouse;
    private OrderStatus orderStatus;

    public Order(User user, Address address, Map<String, Integer> productCountMap)
    {
        this.id = String.valueOf(idCounter++);
        this.user = user;
        this.deliveryAddress = address;
        this.productCountMap = productCountMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Map<String, Integer> getProductCountMap() {
        return productCountMap;
    }

    public void setProductCountMap(Map<String, Integer> productCountMap) {
        this.productCountMap = productCountMap;
    }

    public Warehouse getFulfillingWarehouse() {
        return fulfillingWarehouse;
    }

    public void setFulfillingWarehouse(Warehouse fulfillingWarehouse) {
        this.fulfillingWarehouse = fulfillingWarehouse;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
