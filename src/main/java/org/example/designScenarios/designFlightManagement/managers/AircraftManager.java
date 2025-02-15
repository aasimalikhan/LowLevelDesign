package org.example.designScenarios.designFlightManagement.managers;

import org.example.designScenarios.designFlightManagement.exceptions.AircraftAlreadyExistsException;
import org.example.designScenarios.designFlightManagement.exceptions.AircraftNotFoundException;
import org.example.designScenarios.designFlightManagement.models.Aircraft;

import java.util.ArrayList;
import java.util.List;

public class AircraftManager {
    private final List<Aircraft> allAircraft;
    private static AircraftManager aircraftManager;

    public AircraftManager() {
        this.allAircraft = new ArrayList<>();
    }

    public static AircraftManager getInstance()
    {
        if(aircraftManager == null)
        {
            synchronized (AircraftManager.class)
            {
                aircraftManager = new AircraftManager();
            }
        }
        return aircraftManager;
    }

    public List<Aircraft> getAllAircraft()
    {
        return allAircraft;
    }

    public Aircraft getAircraftById(String aircraftId) throws AircraftNotFoundException {
        return allAircraft.stream().filter((aircraft) -> aircraft.getId().equals(aircraftId)).findFirst().orElseThrow(() -> new AircraftNotFoundException(
                "Aircraft with id: " + aircraftId + " not found!"
        ));
    }

    public void addAircraft(Aircraft aircraft) throws AircraftAlreadyExistsException {
        boolean aircraftExists = allAircraft.stream().anyMatch(existingAircraft -> existingAircraft.getId().equals(aircraft.getId()));
        if(aircraftExists)
        {
            throw new AircraftAlreadyExistsException("Aircraft with id: " + aircraft.getId() + " already exists");
        }
        allAircraft.add(aircraft);
    }
}
