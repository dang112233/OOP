package hus.oop.lab6.circlecylinder;

public class TestMain {

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3.0, "red", 4.0);

        System.out.println(cylinder);
        System.out.println(cylinder.getVolume());
    }
}
