package hus.oop.lab3.exercises3;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class PerfectNumberList {

    public static int[] divisor(int n) {
        int [] array = new int[n];
        int idx = 0;
        for (int i = 1; i <= n/2; i ++) {
            if (n % i == 0) {
                array[idx] = i;
                idx ++;
            }
        }
        return array;
    }

    public static int sum(int [] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }
    public static boolean isPerfect(int aPosInt) {
        if (aPosInt == sum(divisor(aPosInt))) {
            return true;
        }
        return false;
    }

    public static boolean isDeficient(int aPosInt) {
        if (aPosInt > sum(divisor(aPosInt))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(" Enter the upper bound: " );
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("These numbers are perfect:");
        for (int i = 1; i < n; i++) {
            if(isPerfect(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("These number are neither deficient nor perfrct:");
        for (int i = 1; i < n; i++) {
            if (!isDeficient(i) && isPerfect(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
