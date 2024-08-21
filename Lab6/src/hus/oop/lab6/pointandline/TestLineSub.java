package hus.oop.lab6.pointandline;

public class TestLineSub {

    public static void main(String[] args) {
        LineSub ls1 = new LineSub(0, 0, 3 ,4);
        System.out.println(ls1);

        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 3);
        LineSub ls2 = new LineSub(p1, p2);
        System.out.println(ls2);

        System.out.println(ls2.getLength());
        System.out.println(ls2.getGradient());
    }
}
