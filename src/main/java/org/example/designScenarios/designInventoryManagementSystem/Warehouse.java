package org.example.designScenarios.designInventoryManagementSystem;

import java.util.List;

public class Warehouse {
    private static int idCounter = 101;

    private String id;
    private Inventory inventory;
    private Address address;
    private List<Order> orders;

    public Warehouse(Address address)
    {
        this.id = String.valueOf(idCounter);
        this.inventory = new Inventory();
        this.address = address;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
