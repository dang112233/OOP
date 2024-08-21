package hus.oop.lab4.my;

public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle myTriangle = new MyTriangle(5, 2, 3, 4, 1, 2);
        System.out.println(myTriangle);
        System.out.println(myTriangle.getType());
        System.out.println("perimeter is: " + myTriangle.getPerimeter());
    }
}
