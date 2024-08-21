package hus.oop.lab11.iterator.example;

public class IteratorPatternExample {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Book 1"));
        library.addBook(new Book("Book 2"));
        library.addBook(new Book("Book 3"));

        Iterator iterator = library.getIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println("Book Title: " + book.getTitle());
        }
    }
}
