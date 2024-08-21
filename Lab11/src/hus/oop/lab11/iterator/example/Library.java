package hus.oop.lab11.iterator.example;

import java.util.ArrayList;
import java.util.List;
public class Library {
    private List<Book> books;
    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Iterator getIterator() {
        return new LibraryIterator(this.books);
    }
}
