package org.example.caseStudies.designInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCounter = 101;

    private String id;
    private String name;
    private List<Order> orders;

    public User(String name)
    {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
