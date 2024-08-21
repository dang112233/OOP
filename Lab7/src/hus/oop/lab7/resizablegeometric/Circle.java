package hus.oop.lab7.resizablegeometric;

public class Circle implements GeometricObject {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ']';
    }

    @Override
    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
}

