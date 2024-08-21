package hus.oop.lab6.shape;

public class Square extends Rectangle {
    private double side;
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }


    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Square[" + super.toString() + ']';
    }
}
