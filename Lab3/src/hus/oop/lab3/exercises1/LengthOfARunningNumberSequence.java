package hus.oop.lab3.exercises1;

import java.util.Scanner;

public class LengthOfARunningNumberSequence {

    public static int numOfDigits(int n){
        return String.valueOf(n).length();
    }
    public static int lenNumberSequence(int n) {
        if (n == 1) {
            return 1;
        } else {
            return lenNumberSequence(n-1) + numOfDigits(n);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter your number n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("S(" + n + ") = " + lenNumberSequence(n));
    }
}