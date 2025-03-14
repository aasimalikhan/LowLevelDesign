package org.example.caseStudies.designVehicleRentalManagementSystem.models;

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
