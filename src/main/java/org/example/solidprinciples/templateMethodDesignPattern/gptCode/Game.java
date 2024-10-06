package org.example.solidprinciples.templateMethodDesignPattern.gptCode;

public abstract class Game {
    public final void play()
    {
        initialize();
        startPlay();
        endPlay();
    }
    public abstract void initialize();
    public abstract void startPlay();
    public abstract void endPlay();

}
