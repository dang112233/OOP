package hus.oop.lab11.abstractfactory.observerpattern;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RoundedSquare::draw() method.");
    }
}
