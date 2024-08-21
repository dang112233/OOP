package hus.oop.lab11.iterator.example;

import java.util.List;
public class LibraryIterator implements Iterator {
    private List<Book> books;
    private int position;

    public LibraryIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Object next() {
        return hasNext() ? books.get(position++) : null;
    }
}
