package org.example.solidprinciples.flyweightDesignPattern.gptCode.badCode;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Tree> trees = new ArrayList<>();
    public void plantTree(String type, String color, String texture, int x, int y) {
        Tree tree = new Tree(type, color, texture, x, y);
        trees.add(tree);
    }
    public void drawForest() {
        for(Tree tree: trees) {
            tree.draw();
        }
    }
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree("Oak", "Green", "Rough", 10, 20);
        forest.plantTree("Pine", "Green", "Smooth", 30, 40);
        forest.plantTree("Oak", "Green", "Rough", 50, 60);
        forest.drawForest();
    }
}
