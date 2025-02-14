package org.example.designScenarios.designFlightManagement.managers;

import org.example.designScenarios.designFlightManagement.exceptions.UserNotFoundException;
import org.example.designScenarios.designFlightManagement.models.Passenger;
import org.example.designScenarios.designFlightManagement.models.User;

import java.util.ArrayList;
import java.util.List;

public class PassengerManager {
    private List<Passenger> allPassengers;
    private static PassengerManager userManager;

    private PassengerManager() {
        allPassengers = new ArrayList<>();
    }

    public static PassengerManager getInstance()
    {
        if(userManager == null)
        {
            synchronized (PassengerManager.class)
            {
                userManager = new PassengerManager();
            }
        }
        return userManager;
    }

    public Passenger getPassengerById(String userId) throws UserNotFoundException {
        return allPassengers.stream().filter((user) -> user.getId().equals(userId)).findFirst().orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
    }
}
