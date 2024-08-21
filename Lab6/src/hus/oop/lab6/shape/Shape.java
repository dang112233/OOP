package hus.oop.lab6.shape;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        if (color == "green" & filled == true) {
            return true;
        }
        return false;
    }

    public void setFilled(boolean filled) {

    }

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }

}
