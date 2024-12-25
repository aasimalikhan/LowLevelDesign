package org.example.designScenarios.designInventoryManagementSystem;

import org.example.designScenarios.designInventoryManagementSystem.manager.OrderManager;
import org.example.designScenarios.designInventoryManagementSystem.manager.UserManager;
import org.example.designScenarios.designInventoryManagementSystem.manager.WarehouseManager;

public class designInventoryManagementSystem {
    public static void main(String[] args) {
        WarehouseManager warehouseManager = new WarehouseManager();
        UserManager userManager = new UserManager();
        OrderManager orderManager = new OrderManager();
    }
}
