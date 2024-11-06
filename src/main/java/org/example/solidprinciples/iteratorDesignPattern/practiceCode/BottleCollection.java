package org.example.solidprinciples.iteratorDesignPattern.practiceCode;

public class BottleCollection implements Collection{
    private Bottle[] bottles;
    private int index;
    public BottleCollection(int size)
    {
        bottles = new Bottle[size];
    }
    public void addBottle(Bottle bottle)
    {
        if(index < bottles.length)
        {
            bottles[index++] = bottle;
        }
    }
    @Override
    public Iterator<Bottle> getIterator() {
        return new BottleIterator(bottles);
    }
}
