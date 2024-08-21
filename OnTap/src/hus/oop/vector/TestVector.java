package hus.oop.vector;

import java.util.Random;


/*


 Lỗiii..


 */

public class TestVector {
    public static void main(String[] args) {
        // Sinh ngẫu nhiên một số tự nhiên n
        Random random = new Random();
        int n = random.nextInt(10) + 1; // Random number between 1 and 10

        // Tạo ra các vector có kích thước n với các phần tử được sinh ngẫu nhiên
        MyArrayVector arrayListVector1 = new MyArrayVector();
        MyArrayVector arrayListVector2 = new MyArrayVector();
        MyListVector listVector1 = new MyListVector();
        MyListVector listVector2 = new MyListVector();

        for (int i = 0; i < n; i++) {
            double value = random.nextDouble() * 100; // Random double between 0 and 100
            arrayListVector1.insert(value);
            arrayListVector2.insert(value);
            listVector1.insert(value);
            listVector2.insert(value);
        }

        // Test chức năng của các vector
        testFunctionality(arrayListVector1, arrayListVector2);
        testFunctionality(listVector1, listVector2);
    }

    private static void testFunctionality(MyVector vector1, MyVector vector2) {
        System.out.println("Vector 1: " + vector1.coordinates());
        System.out.println("Vector 2: " + vector2.coordinates());

        // Thêm một phần tử vào vector ở vị trí cuối cùng
        vector1.insert(10.0);
        System.out.println("After inserting 10.0 to vector 1: " + vector1.coordinates());

        // Thêm một phần tử vào vector ở vị trí index
        vector2.insert(20.0, 2);
        System.out.println("After inserting 20.0 at index 2 to vector 2: " + vector2.coordinates());

        // Xóa phần tử ở vị trí index
        vector1.remove(3);
        System.out.println("After removing element at index 3 from vector 1: " + vector1.coordinates());

        // Sửa giá trị phần tử ở vị trí index
        vector2.set(30.0, 4);
        System.out.println("After setting element at index 4 of vector 2 to 30.0: " + vector2.coordinates());

        // Cộng hai vector
        MyVector sum = vector1.add(vector2);
        System.out.println("Sum of vector 1 and vector 2: " + sum.coordinates());

        // Nhân vector với vô hướng
        MyVector scalarProduct = vector1.scale(2.0);
        System.out.println("Scalar product of vector 1 with 2.0: " + scalarProduct.coordinates());

        // Tích vô hướng 2 vector
        double dotProduct = vector1.dot(vector2);
        System.out.println("Dot product of vector 1 and vector 2: " + dotProduct);

        // Chuẩn của vector
        double norm = vector1.norm();
        System.out.println("Norm of vector 1: " + norm);

        System.out.println("-------------------------------------------");
    }
}
