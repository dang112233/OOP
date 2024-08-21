package hus.oop.lab3.exercises2;

public class BubbleSort {

    public static void main(String[] args) {
        int [] array = {9, 2, 4, 1, 5};

        System.out.println("Original array:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void bubbleSort(int [] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int swap = array[i];
                    array[i] = array[i + 1];
                    array[i+1] = swap;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
