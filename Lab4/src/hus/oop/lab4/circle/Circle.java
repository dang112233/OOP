package hus.oop.lab4.circle;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle[radius = " + this.radius + ", color = " + this.color + "]";
    }
}
