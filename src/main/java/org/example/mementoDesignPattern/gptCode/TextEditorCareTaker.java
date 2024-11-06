package org.example.mementoDesignPattern.gptCode;

import java.util.Stack;

public class TextEditorCareTaker {
    Stack<TextEditorMemento> history = new Stack<>();
    public void addSnapshot(TextEditorMemento memento)
    {
        history.push(memento);
    }
    public TextEditorMemento undo()
    {
        if(!history.isEmpty())
        {
            TextEditorMemento memento = history.pop();
            return memento;
        }
        return null;
    }
}
