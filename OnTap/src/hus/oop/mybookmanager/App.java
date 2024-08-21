package hus.oop.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */
        testOriginalData();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
        testGetHighestPriceBook();
        testGetLowestPriceBook();
        testGetHighestNumberOfPagesBook();
        testGetLowestNumberOfPagesBook();
    }

    public static void init() {
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */

                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(price)
                        .withPublisher(publisher)
                        .build();

                BookManager.getInstance().insertAtEnd(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        BookManager manager = BookManager.getInstance();
        MyIterator iterator = manager.getBookList().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        BookManager manager = BookManager.getInstance();
        MyList booksByAuthor = manager.filterBooksOfAuthor("Author Name");
        MyIterator iterator = booksByAuthor.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        BookManager manager = BookManager.getInstance();
        MyList booksByPublisher = manager.filterBooksOfPublisher("Publisher Name");
        MyIterator iterator = booksByPublisher.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        BookManager manager = BookManager.getInstance();
        MyList booksByGenre = manager.filterBooksOfGenre("Genre Name");
        MyIterator iterator = booksByGenre.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook() {
        BookManager manager = BookManager.getInstance();
        Book highestPriceBook = manager.highestPriceBook();
        System.out.println("Highest Price Book: " + highestPriceBook);
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook() {
        BookManager manager = BookManager.getInstance();
        Book lowestPriceBook = manager.lowestPriceBook();
        System.out.println("Lowest Price Book: " + lowestPriceBook);
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook() {
        BookManager manager = BookManager.getInstance();
        Book highestPagesBook = manager.highestNumberOfPagesBook();
        System.out.println("Highest Number of Pages Book: " + highestPagesBook);
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook() {
        BookManager manager = BookManager.getInstance();
        Book lowestPagesBook = manager.lowestNumberOfPagesBook();
        System.out.println("Lowest Number of Pages Book: " + lowestPagesBook);
    }
}