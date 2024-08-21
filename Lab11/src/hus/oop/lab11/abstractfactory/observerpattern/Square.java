package hus.oop.lab11.abstractfactory.observerpattern;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
