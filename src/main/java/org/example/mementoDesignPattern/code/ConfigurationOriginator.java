package org.example.mementoDesignPattern.code;

public class ConfigurationOriginator {

    public int height;
    public int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ConfigurationOriginator(int height, int width)
    {
        this.height = height;
        this.width = width;
    }
    public ConfigurationMemento createMemento()
    {
        return new ConfigurationMemento(height, width);
    }
    public void restoreMemento(ConfigurationMemento memento)
    {
        this.height = memento.height;
        this.width = memento.width;
    }

}
