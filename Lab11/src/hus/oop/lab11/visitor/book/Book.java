package hus.oop.lab11.visitor.book;

public interface Book {
    void accept(Visitor v);
}
