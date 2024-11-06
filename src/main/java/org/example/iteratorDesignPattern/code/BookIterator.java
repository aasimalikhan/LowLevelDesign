package org.example.iteratorDesignPattern.code;

public class BookIterator implements Iterator{
    private Book[] books;
    private int position = 0;
    public BookIterator(Book[] books)
    {
        this.books = books;
    }
    @Override
    public boolean hasNext() {
        return position < books.length && books[position] != null;
    }

    @Override
    public Object next() {
        return books[position++];
    }
}
