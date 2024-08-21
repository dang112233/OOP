package hus.oop.lab3.exercises2;

public class SelectionSort {

    public static void main(String[] args) {
        int [] array = {9, 2, 4, 1, 5};

        System.out.println("Original array:");
        printArray(array);

        selectionSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void selectionSort(int [] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
