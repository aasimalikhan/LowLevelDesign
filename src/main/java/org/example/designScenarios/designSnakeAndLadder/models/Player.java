package org.example.designScenarios.designSnakeAndLadder.models;

public class Player {
    private String id;
    private int currentPosition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String id) {
        this.id = id;
        this.currentPosition = 0;
    }
}
