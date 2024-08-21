package hus.oop.lab3.exercises2;

import java.util.Scanner;

public class LinerSearch {

    public static boolean linearSearch(int [] array, int key) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static int linearSearchIndex(int [] array, int key) {
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] array = {1, 5, 9, 2, 4, 6};
        int key = 9;

        System.out.println(linearSearch(array, key));
        System.out.println(linearSearchIndex(array, key));
    }
}
