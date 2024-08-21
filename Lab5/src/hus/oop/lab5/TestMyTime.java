package hus.oop.lab5;

public class TestMyTime {

    public static void main(String[] args) {
        MyTime mytime1 = new MyTime();
        System.out.println(mytime1);
        MyTime mytime2 = new MyTime(10, 20, 30);
        System.out.println(mytime2);

        mytime1.setHour(4);
        mytime1.setMinute(5);
        mytime1.setSecond(6);
        System.out.println(mytime1);
        System.out.println("Hour: " + mytime1.getHour());
        System.out.println("Minute: " + mytime1.getMinute());
        System.out.println("Second: " + mytime1.getSecond());

        mytime1.setTime(23, 59, 58);
        System.out.println(mytime1);

        System.out.println(mytime1.nextSecond());
        System.out.println(mytime1.nextSecond().nextSecond());
        System.out.println(mytime1.nextMinute());
        System.out.println(mytime1.nextHour());

        mytime1.setTime(0, 0, 0);
        System.out.println(mytime1);
        System.out.println(mytime1.previousSecond());
        System.out.println(mytime1.previousMinute());
        System.out.println(mytime1.previousHour());
    }
}
