package hus.oop.search;

import java.util.Random;

public class TestBinarySearch {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
          mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        // Generate a random natural number in the range [20 - 30]
        Random random = new Random();
        int size = random.nextInt(11) + 20;

        // Generate a random array of double numbers
        double[] data = new double[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextDouble() * 100; // Generate random double numbers between 0 and 100
        }

        // Create an instance of BinarySearch
        BinarySearch binarySearch = BinarySearch.getInstance();

        // Test binary search with different sorting algorithms
        testBinarySearch(binarySearch, data, "Bubble Sort");
        testBinarySearch(binarySearch, data, "Insertion Sort");
        testBinarySearch(binarySearch, data, "Selection Sort");
    }

    // Method to test binary search with a given sorting algorithm
    private static void testBinarySearch(BinarySearch binarySearch, double[] data, String sortingAlgorithm) {
        // Create a sorter based on the given sorting algorithm
        Sorter sorter;
        switch (sortingAlgorithm) {
            case "Bubble Sort":
                sorter = new BubbleSort();
                break;
            case "Insertion Sort":
                sorter = new InsertionSort();
                break;
            case "Selection Sort":
                sorter = new SelectionSort();
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm");
        }

        // Set the sorter for binary search
        binarySearch.setSorter(sorter);

        // Print the sorting algorithm being used
        System.out.println("Using " + sortingAlgorithm + " Algorithm:");

        // Print the array before sorting
        System.out.print("Before sorting: ");
        printArray(data);

        // Sort the array
        sorter.sort(data, true); // Sorting in ascending order

        // Print the array after sorting
        System.out.print("After sorting: ");
        printArray(data);

        // Randomly select a value to search for
        Random random = new Random();
        double valueToFind = data[random.nextInt(data.length)];

        // Perform binary search
        int index = binarySearch.search(data, valueToFind);

        // Print the result of binary search
        System.out.println("Binary search giá trị " + valueToFind + ": " + index);
        System.out.println();
    }

    // Method to print an array
    private static void printArray(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }
}
