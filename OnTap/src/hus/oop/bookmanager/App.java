package hus.oop.bookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortIncreasingGenreAndPrice();
        testSortDecreasingGenreAndPrice();
        testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();
        testFilterBooksLowestPrice();
        testFilterBooksHighestPrice();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
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

            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

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
                bookManager.append(newBook);
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
        List<Book> books = bookManager.getBookList();
        BookManager.print(books);
    }

    /**
     * Test sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, sau đó theo giá giảm dần.
     */
    public static void testSortIncreasingGenreAndPrice() {
        List<Book> sortedBooks = bookManager.sortIncreasingGenreAndPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, sau đó theo giá giảm dần.
     */
    public static void testSortDecreasingGenreAndPrice() {
        List<Book> sortedBooks = bookManager.sortDecreasingGenreAndPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test sắp xếp sách theo giá tăng dần.
     */
    public static void testPriceOfBooksIncreasing() {
        List<Book> sortedBooks = bookManager.sortIncreasingPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test sắp xếp sách theo giá giảm dần
     */
    public static void testPriceOfBooksDecreasing() {
        List<Book> sortedBooks = bookManager.sortDecreasingPrice();
        BookManager.print(sortedBooks);
    }

    /**
     * Test lọc sách có giá rẻ nhất.
     */
    public static void testFilterBooksLowestPrice() {
        List<Book> sortedBooks = bookManager.sortIncreasingPrice();
        BookManager.print(sortedBooks.subList(0, 1));
    }

    /**
     * Test lọc sách có giá cao nhất.
     */
    public static void testFilterBooksHighestPrice() {
        List<Book> sortedBooks = bookManager.sortDecreasingPrice();
        BookManager.print(sortedBooks.subList(0, 1));
    }

    /**
     * Test lọc sách theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        List<Book> filteredBooks = bookManager.filterBooksOfAuthor("AuthorName");
        BookManager.print(filteredBooks);
    }

    /**
     * Test lọc sách theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        List<Book> filteredBooks = bookManager.filterBooksOfPublisher("PublisherName");
        BookManager.print(filteredBooks);
    }

    /**
     * Test lọc sách theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        List<Book> filteredBooks = bookManager.filterBooksOfGenre("GenreName");
        BookManager.print(filteredBooks);
    }
}
