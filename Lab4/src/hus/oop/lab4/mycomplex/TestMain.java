package hus.oop.lab4.mycomplex;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        MyComplex myComplex1 = new MyComplex();
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        Scanner sc = new Scanner(System.in);
        myComplex1.setReal(sc.nextDouble());
        myComplex1.setImag(sc.nextDouble());

        MyComplex myComplex2 = new MyComplex();
        System.out.print("Enter complex number 2 (real and imaginary part): ");
        myComplex2.setReal(sc.nextDouble());
        myComplex2.setImag(sc.nextDouble());

        System.out.println();
        System.out.println("Number 1 is: " + myComplex1);

        if (!myComplex1.isReal()) {
            System.out.println(myComplex1 + " is NOT a pure real number");
        }

        if (!myComplex1.isImag()) {
            System.out.println(myComplex1 + " is NOT a pure imaginary number");
        }

        System.out.println();
        System.out.println("Number 2 is: " + myComplex2);
        if (!myComplex2.isReal()) {
            System.out.println(myComplex2 + " is NOT a pure real number");
        }

        if (!myComplex2.isImag()) {
            System.out.println(myComplex2 + " is NOT a pure imaginary number");
        }

        System.out.println();
        if (!myComplex1.equals(myComplex2)) {
            System.out.println(myComplex1 + " is NOT equal to " + myComplex2);
        }

        System.out.println(myComplex1 + " + " + myComplex2 + " = " + myComplex1.addNew(myComplex2));
    }
}
