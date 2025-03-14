package org.example.caseStudies.designInventoryManagementSystem.strategy;

import org.example.caseStudies.designInventoryManagementSystem.Address;
import org.example.caseStudies.designInventoryManagementSystem.Warehouse;

import java.util.List;

public abstract  class WarehouseSelectionStrategy {
    public abstract Warehouse getWarehouse(Address address, List<Warehouse> warehouses);
}