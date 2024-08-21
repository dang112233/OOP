package hus.oop.lab3.exercises2;

public class BinarySearch {

    public static boolean binarySearch(int [] array, int key, int fromIdx, int toIdx) {
        if (fromIdx == toIdx - 1) {
            if (key == array[fromIdx]) {
                return true;
            } else {
                return false;
            }
        }

        int midIdx = (int)(fromIdx + toIdx) / 2;
        if (key == array[midIdx]) {
            return true;
        } else if (key < array[midIdx]) {
            toIdx = midIdx;
        } else {
            fromIdx = midIdx;
        }
        return binarySearch(array, key, fromIdx, toIdx);
    }

    public static void main(String[] args) {
        int [] array = {2, 5, 9, 1, 4, 6};
        int fromIdx = 0;
        int toIdx = 5;
        int key = 9;

        System.out.println(binarySearch(array, key, fromIdx, toIdx));
    }
}
