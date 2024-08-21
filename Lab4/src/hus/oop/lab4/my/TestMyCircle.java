package hus.oop.lab4.my;

public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle myCircle1 = new MyCircle(2, 2, 2);
        System.out.println(myCircle1);
        System.out.println("area: " + myCircle1.getArea());
        System.out.println("circumference: " + myCircle1.getCircumference());

        MyCircle myCircle2 = new MyCircle(new MyPoint(3, 3), 5);
        System.out.println(myCircle2);
        System.out.println("distance: " + myCircle1.distance(myCircle2));
    }
}
