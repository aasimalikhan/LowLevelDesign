package org.example.solidprinciples.flyweightDesignPattern.goodCode.scenario2.badCode;

public class Character {
    char character;
    String fontType;
    int size;
    int row;
    int column;

    Character(char character, String fontType, int size, int row, int column){
        this.character = character;
        this.fontType = fontType;
        this.size = size;
        this.row = row;
        this.column = column;
    }
}
