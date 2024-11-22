package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    private StoreManager storeManager;
    private UserManager userManager;
    public VehicleRentalSystem()
    {
        this.storeManager = new StoreManager();
        this.userManager = new UserManager();
    }

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
