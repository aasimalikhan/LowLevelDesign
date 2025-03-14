package org.example.caseStudies.designInventoryManagementSystem.strategy;

import org.example.caseStudies.designInventoryManagementSystem.Address;
import org.example.caseStudies.designInventoryManagementSystem.Warehouse;

import java.util.List;

public class NonBusyWarehouseSelectionStrategy extends WarehouseSelectionStrategy{
    @Override
    public Warehouse getWarehouse(Address address, List<Warehouse> warehouses) {
        return warehouses.getFirst();
    }
}
