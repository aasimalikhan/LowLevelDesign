package org.example.solidprinciples.flyweightDesignPattern.gptCode.badCode;

public class Tree {
    private String type;
    private String color;
    private String texture;
    private int x;
    private int y;
    public Tree(String type, String color, String texture, int x, int y)
    {
        this.type = type;
        this.color = color;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }
    public void draw()
    {
        System.out.println("Drawing a " + type + " tree at (" + x + ", " + y + ")");
    }
}
