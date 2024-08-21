package hus.oop.lab3.exercises1;

import java.util.Scanner;

public class GcdRecursive {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number a: ");
        int a = sc.nextInt();

        System.out.print("Enter number b: ");
        int b = sc.nextInt();

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
    }
}
