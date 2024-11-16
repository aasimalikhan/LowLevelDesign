package org.example.solidprinciples.flyweightDesignPattern;

public class Robot {
    int coordinateX;
    int coordinateY;
    String type;
    Sprites body;

    Robot(int x, int y, String type, Sprites body){
        this.coordinateX = x;
        this.coordinateY = y;
        this.type = type;
        this.body = body;
    }
}
