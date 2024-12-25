package org.example.designScenarios.designInventoryManagementSystem.manager;

import org.example.designScenarios.designInventoryManagementSystem.Address;
import org.example.designScenarios.designInventoryManagementSystem.Warehouse;
import org.example.designScenarios.designInventoryManagementSystem.strategy.NearestWarehouseSelectionStrategy;
import org.example.designScenarios.designInventoryManagementSystem.strategy.WarehouseSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class WarehouseManager {
    private List<Warehouse> warehouses;
    private WarehouseSelectionStrategy strategy;

    public WarehouseManager()
    {
        this.warehouses = new ArrayList<>();
        strategy = new NearestWarehouseSelectionStrategy();
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void addWarehouse(Warehouse warehouse)
    {
        warehouses.add(warehouse);
    }
    public Warehouse getBestWarehouse(Address address)
    {
        return strategy.getWarehouse(address, warehouses);
    }
}
