package hus.oop.lab5;

public class TestMyComplex {

    public static void main(String[] args) {
        MyComplex myComplex1 = new MyComplex(1.2, 3.4);
        System.out.println("Number 1: " + myComplex1);
        System.out.println("real number: " + myComplex1.getReal());
        System.out.println("imaginary number: " + myComplex1.getImag());

        myComplex1.isReal();
        myComplex1.isImaginary();

        MyComplex myComplex2 = new MyComplex();
        myComplex2.setReal(2.1);
        myComplex2.setImag(4.3);

        System.out.println("Number 2: " + myComplex2);
        System.out.println(myComplex1.equals(1.2, 3.4));
        System.out.println(myComplex1.equals(myComplex2));

        MyComplex myComplex3 = new MyComplex(5.5, 6.6);
        myComplex1.addInto(myComplex3);
        System.out.println(myComplex1);
        myComplex1.addNew(myComplex3);
        System.out.println(myComplex1);
    }
}
