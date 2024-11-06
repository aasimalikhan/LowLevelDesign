package org.example.solidprinciples.iteratorDesignPattern.practiceCode;

public class iteratorDesignPatternpracticeCode {
    public static void main(String[] args) {
        BottleCollection collection = new BottleCollection(10);
        Bottle bottle1 = new Bottle("1", 2.2, "milton");
        Bottle bottle2 = new Bottle("2", 3.2, "milton");
        Bottle bottle3 = new Bottle("3", 4.2, "milton");
        collection.addBottle(bottle1);
        collection.addBottle(bottle2);
        collection.addBottle(bottle3);
        Iterator<Bottle> iterator = collection.getIterator();
        while(iterator.hasNext())
        {
            Bottle bottle = iterator.next();
            System.out.println(bottle);
        }
    }
}
