package org.example.designScenarios.designFlightManagement.managers;

import org.example.designScenarios.designFlightManagement.exceptions.UserNotFoundException;
import org.example.designScenarios.designFlightManagement.models.Passenger;
import org.example.designScenarios.designFlightManagement.models.PassengerType;
import org.example.designScenarios.designFlightManagement.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> allUsers;
    private List<Passenger> allPassengers;

    private static UserManager userManager;

    private UserManager() {
        allUsers = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (userManager == null) {
            synchronized (UserManager.class) {
                userManager = new UserManager();
            }
        }
        return userManager;
    }

    public Passenger getPassengerById(String userId) throws UserNotFoundException {
        return allPassengers.stream().filter((passenger) -> passenger.getId().equals(userId)).findFirst().orElseThrow(() -> new UserNotFoundException("Passenger with id: " + userId + " not found"));
    }

    public User getUserById(String userId) throws UserNotFoundException {
        return allUsers.stream().filter((user) -> user.getId().equals(userId)).findFirst().orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
    }

    public void addUser(User user) throws UserNotFoundException {
        boolean userExists = allUsers.stream().anyMatch(existingUser -> existingUser.getId().equals(user.getId()));

        if(userExists)
        {
            throw new UserNotFoundException("User with id: " + user.getId() + " already exists");
        }
        allUsers.add(user);
    }

    public void addPassenger(Passenger passenger) throws UserNotFoundException {
        boolean passengerExists = allPassengers.stream().anyMatch(existingPassenger -> existingPassenger.getId().equals(passenger.getId()));

        if(passengerExists)
        {
            throw new UserNotFoundException("Passenger with id: " + passenger.getId() + " already exists");
        }
        allPassengers.add(passenger);
    }
}
