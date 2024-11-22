package org.example.designScenarios.designVehicleRentalManagementSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManager {
    private List<User> users;
    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean deleteUser(String userId) {
        Optional<User> userToDelete = users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();

        if (userToDelete.isPresent()) {
            users.remove(userToDelete.get());
            return true;
        }
        return false;
    }

    public User getUserById(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
