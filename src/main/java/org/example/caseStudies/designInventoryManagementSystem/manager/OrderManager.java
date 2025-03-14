package org.example.caseStudies.designInventoryManagementSystem.manager;

import org.example.caseStudies.designInventoryManagementSystem.Order;
import org.example.caseStudies.designInventoryManagementSystem.Warehouse;

import java.util.List;
import java.util.Optional;

public class OrderManager {
    private List<Order> orders;
    public void addOrder(Order order)
    {
        orders.add(order);
    }
    public List<Order> getOrders()
    {
        return orders;
    }
    public Order getOrder(String id)
    {
        Optional<Order> order = orders.stream().filter(item -> item.getId() == id).findFirst();
        return order.orElse(null);
    }

    public void placeOrder(Warehouse warehouse, Order order) throws Exception {
        warehouse.getInventory().fulfillOrder(order.getProductCountMap());
        orders.add(order);
    }
}
