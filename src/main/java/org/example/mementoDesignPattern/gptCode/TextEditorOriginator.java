package org.example.mementoDesignPattern.gptCode;

public class TextEditorOriginator {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public TextEditorMemento createMemento()
    {
        return new TextEditorMemento(this.text);
    }
    public void restoreMemento(TextEditorMemento memento)
    {
        this.text = memento.getText();
    }
}
