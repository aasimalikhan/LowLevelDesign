package org.example.solidprinciples.mementoDesignPattern.code;

import java.util.Stack;

public class ConfigurationCareTaker {
    Stack<ConfigurationMemento> history = new Stack<>();
    public void addMemento(ConfigurationMemento memento)
    {
        history.push(memento);
    }

    public ConfigurationMemento undo()
    {
        if(!history.isEmpty())
        {
            ConfigurationMemento prevMemento = history.pop();
            return prevMemento;
        }
        return null;
    }
}
