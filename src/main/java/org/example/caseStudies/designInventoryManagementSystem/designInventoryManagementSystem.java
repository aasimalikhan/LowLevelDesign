package org.example.caseStudies.designInventoryManagementSystem;

import org.example.caseStudies.designInventoryManagementSystem.manager.OrderManager;
import org.example.caseStudies.designInventoryManagementSystem.manager.UserManager;
import org.example.caseStudies.designInventoryManagementSystem.manager.WarehouseManager;

public class designInventoryManagementSystem {
    public static void main(String[] args) {
        WarehouseManager warehouseManager = new WarehouseManager();
        UserManager userManager = new UserManager();
        OrderManager orderManager = new OrderManager();
    }
}
