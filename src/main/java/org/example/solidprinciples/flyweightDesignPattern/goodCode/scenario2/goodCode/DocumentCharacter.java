package org.example.solidprinciples.flyweightDesignPattern.goodCode.scenario2.goodCode;

public class DocumentCharacter implements ILetter{
    private char character;
    private String fontType;
    private int size;

    DocumentCharacter(char character, String fontType, int size)
    {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    // only getter methods
    public void display(int row, int column) {

    }
}


