package org.example.mementoDesignPattern.gptCode;

public class mementoDesignPatterngptCode {
    public static void main(String[] args) {
        TextEditorCareTaker careTaker = new TextEditorCareTaker();
        TextEditorOriginator textEditor = new TextEditorOriginator();
        textEditor.setText("mainstream media is a boon");
        TextEditorMemento snapshot1 = textEditor.createMemento();
        careTaker.addSnapshot(snapshot1);

        textEditor.setText("kya bolte company kama rele bhot money");
        System.out.println("TextEditor state");
        System.out.println(textEditor.getText());

        System.out.println("______________________");
        TextEditorMemento mementoRevertToSnapShot1 = careTaker.undo();
        textEditor.restoreMemento(mementoRevertToSnapShot1);
        System.out.println("TextEditor state");
        System.out.println(textEditor.getText());

    }
}
