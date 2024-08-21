package hus.oop.lab3.exercises1;

import java.util.Scanner;

public class FibonacciRecursive {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter your number n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("F(" + n + ") = " + fibonacci(n) );
    }
}
