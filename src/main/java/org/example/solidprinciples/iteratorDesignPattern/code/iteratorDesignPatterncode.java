package org.example.solidprinciples.iteratorDesignPattern.code;

public class iteratorDesignPatterncode {
    public static void main(String[] args) {
        Library library = new Library(10);
        Book book1 = new Book("2 states", "chetan bhagat");
        Book book2 = new Book("half girlfriend", "chetan bhagat");
        library.addBook(book1);
        library.addBook(book2);
        Iterator<Book> bookIterator = library.createIterator();
        while(bookIterator.hasNext())
        {
            Book book = bookIterator.next();
            System.out.println(book);
        }
    }
}
