package org.example.solidprinciples.flyweightDesignPattern.goodCode.scenario1;

import org.example.solidprinciples.flyweightDesignPattern.Sprites;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {
    public static Map<String, IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {
        if(roboticObjectCache.containsKey(robotType))
        {
            return roboticObjectCache.get(robotType);
        }
        else
        {
            if(robotType == "HUMANOID")
            {
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanoidRobot(robotType, humanoidSprite);
                roboticObjectCache.put(robotType, humanoidObject);
                return humanoidObject;
            }
            else if(robotType == "ROBOTICDOG") {
                Sprites roboticDogSprite = new Sprites();
                IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSprite);
                roboticObjectCache.put(robotType, roboticDogObject);
                return roboticDogObject;
            }
        }
        return null;
    }

}
