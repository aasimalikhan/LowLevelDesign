package org.example.designScenarios.designInventoryManagementSystem.strategy;

import org.example.designScenarios.designInventoryManagementSystem.Address;
import org.example.designScenarios.designInventoryManagementSystem.Warehouse;

import java.util.List;

public abstract  class WarehouseSelectionStrategy {
    public abstract Warehouse getWarehouse(Address address, List<Warehouse> warehouses);
}