package org.example.designScenarios.designElevatorManagementSystem.manager;

import org.example.designScenarios.designElevatorManagementSystem.models.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FloorManager {
    private final List<Floor> floorList;
    private static FloorManager floorManager;

    private FloorManager() {
        this.floorList = new ArrayList<>();
    }

    public static FloorManager getInstance() {
        if(floorManager == null) {
            synchronized (FloorManager.class)
            {
                floorManager = new FloorManager();
            }
        }
        return floorManager;
    }

    public void addFloor(Floor floor) throws Exception {
        boolean floorExists = floorList.stream().anyMatch((existingFloor) -> existingFloor.getFloorNumber() == floor.getFloorNumber());

        if(floorExists)
        {
            throw new Exception("floor already exusts");
        }
        floorList.add(floor);
    }

    public Floor getFloor(int floorNumber) throws Exception {
        Optional<Floor> floor = floorList.stream().filter((tempFloor) -> tempFloor.getFloorNumber() == floorNumber).findFirst();
        if(floor.isPresent())
        {
            return floor.get();
        }
        throw new Exception("nsajdjsad");
    }
}
