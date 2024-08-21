package hus.oop.lab3.exercises1;

import java.util.Scanner;

public class FactorialRecusive {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter your number n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("factorial(n) = " + factorial(n) + ", for n = " + n);
    }
}
