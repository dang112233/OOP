package hus.oop.statistics;

import java.util.Arrays;
import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        /* TODO

         - Viết các hàm test như yêu cầu và chạy test chương trình.
         - Copy kết quả chạy chương trình và lưu vào file text có tên <Ten_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
          - Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <Ten_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */
        System.out.println("Test Array:");
        testArrayDataSet();
        System.out.println("Test List");
        testListDataSet();
    }

    public static void testArrayDataSet() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên trong đoạn [10, 20], gọi là n.
         - Sinh ra n số thực kiểu double ngẫu nhiên, cho vào tập dữ liệu
         - In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         - Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
         In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         */
        DataSet arrayDataSet = new ArrayDataSet();
        Random random = new Random();

        int n = random.nextInt(11) + 10;

        for (int i = 0; i < n; i++) {
            arrayDataSet.insertAtEnd(random.nextDouble() * 100); // Random giá trị từ 0 đến 100
        }

        BasicStatistic basicStatisticArray = new BasicStatistic();
        basicStatisticArray.setDataSet(arrayDataSet);

        System.out.println("Sample Data: " + arrayDataSet.toString());
        System.out.println("Sample Size: " + basicStatisticArray.size());
        System.out.println("Max Value: " + basicStatisticArray.max());
        System.out.println("Min Value: " + basicStatisticArray.min());
        System.out.println("Mean: " + basicStatisticArray.mean());
        System.out.println("Variance: " + basicStatisticArray.variance());
        System.out.println("Rank: " + Arrays.toString(basicStatisticArray.rank()));
        System.out.println("Median: " + basicStatisticArray.median());

        arrayDataSet.remove(0);
        arrayDataSet.remove(arrayDataSet.size() - 1);
        System.out.println("Sau khi xóa phần tu đầu và cuối: " + arrayDataSet.toString());

    }

    public static void testListDataSet() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên trong đoạn [10, 20], gọi là n.
         - Sinh ra n số thực kiểu double ngẫu nhiên, cho vào tập dữ liệu
         - In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         - Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
         In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
         */
        DataSet listDataSet = new ListDataSet();
        Random random = new Random();
        int n = random.nextInt(11) + 10;
        for (int i = 0; i < n; i++) {
            listDataSet.insertAtEnd(random.nextDouble() * 100); // Random giá trị từ 0 đến 100
        }
        BasicStatistic basicStatisticList = new BasicStatistic();
        basicStatisticList.setDataSet(listDataSet);

        System.out.println("Sample Data: " + listDataSet.toString());
        System.out.println("Sample Size: " + basicStatisticList.size());
        System.out.println("Max Value: " + basicStatisticList.max());
        System.out.println("Min Value: " + basicStatisticList.min());
        System.out.println("Mean: " + basicStatisticList.mean());
        System.out.println("Variance: " + basicStatisticList.variance());
        System.out.println("Rank: " + Arrays.toString(basicStatisticList.rank()));
        System.out.println("Median: " + basicStatisticList.median());

        listDataSet.remove(0);
        listDataSet.remove(listDataSet.size() - 1);
        System.out.println("Sau khi xóa phần tu đầu và cuối: " + listDataSet.toString());

    }
}
