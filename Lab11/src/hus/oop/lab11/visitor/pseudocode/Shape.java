package hus.oop.lab11.visitor.pseudocode;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}