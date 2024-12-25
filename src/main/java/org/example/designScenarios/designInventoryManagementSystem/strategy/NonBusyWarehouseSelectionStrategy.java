package org.example.designScenarios.designInventoryManagementSystem.strategy;

import org.example.designScenarios.designInventoryManagementSystem.Address;
import org.example.designScenarios.designInventoryManagementSystem.Warehouse;

import java.util.List;

public class NonBusyWarehouseSelectionStrategy extends WarehouseSelectionStrategy{
    @Override
    public Warehouse getWarehouse(Address address, List<Warehouse> warehouses) {
        return warehouses.getFirst();
    }
}
