package org.example.templateMethodDesignPattern.gptCode;

public class Chess extends Game{
    @Override
    public void initialize() {
        System.out.println("Chess Game Initialized. Set up the board.");
    }

    @Override
    public void startPlay() {
        System.out.println("Chess Game Started. Make your move.");
    }

    @Override
    public void endPlay() {
        System.out.println("Chess Game Finished! Well played.");
    }
}
