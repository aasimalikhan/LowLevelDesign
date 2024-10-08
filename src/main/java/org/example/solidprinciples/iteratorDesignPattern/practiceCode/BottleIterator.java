package org.example.solidprinciples.iteratorDesignPattern.practiceCode;

public class BottleIterator implements Iterator<Bottle>{
    private Bottle[] bottles;
    private int position = 0;

    public BottleIterator(Bottle[] bottles) {
        this.bottles = bottles;
        this.bottles = bottles;
    }

    @Override
    public boolean hasNext() {
        return position < bottles.length && bottles[position] != null;
    }

    @Override
    public Bottle next() {
        return bottles[position++];
    }
}
