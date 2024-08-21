package hus.oop.lab3.exercises2;

public class InsertionSort {

    public static void main(String[] args) {
        int [] array = {9, 2, 4, 1, 5};

        System.out.println("Original array:");
        printArray(array);

        insertionSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
