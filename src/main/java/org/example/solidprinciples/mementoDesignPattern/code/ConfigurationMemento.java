package org.example.solidprinciples.mementoDesignPattern.code;

public class ConfigurationMemento {
    public int height;
    public int width;

    public ConfigurationMemento(int height, int width)
    {
        this.height = height;
        this.width = width;
    }
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }

}
