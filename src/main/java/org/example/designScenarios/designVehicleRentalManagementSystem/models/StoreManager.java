package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoreManager {
    private List<Store> stores;
    public StoreManager() {
        this.stores = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public boolean deleteStore(String storeId) {
        Optional<Store> storeToDelete = stores.stream()
                .filter(store -> store.getId().equals(storeId))
                .findFirst();

        if (storeToDelete.isPresent()) {
            stores.remove(storeToDelete.get());
            return true; // Store deleted
        }
        return false; // Store not found
    }

    public Store getStoreById(String storeId) {
        return stores.stream()
                .filter(store -> store.getId().equals(storeId))
                .findFirst()
                .orElse(null); // Return null if store not found
    }

    public List<Store> getAllStores() {
        return new ArrayList<>(stores);
    }
}
