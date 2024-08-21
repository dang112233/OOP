package hus.oop.bookmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        if (checkBoundaries(index, bookList.size())) {
            bookList.add(index, book);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        if (checkBoundaries(index, bookList.size() - 1)) {
            bookList.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Bỏ book như tham số truyền vào.
     * @param book
     */
    public void remove(Book book) {
        bookList.remove(book);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        if (checkBoundaries(index, bookList.size() - 1)) {
            return bookList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo genre và sau đó đến title.
     * @return
     */
    public List<Book> sortIncreasingByGenreAndTitle() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return 0;
            }
        });
        return sortedList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortIncreasingGenreAndPrice() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                int genreComparison = left.getGenre().compareTo(right.getGenre());
                if (genreComparison != 0) {
                    return genreComparison;
                }
                return Double.compare(right.getPrice(), left.getPrice());
            }
        });
        return sortedList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortDecreasingGenreAndPrice() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                int genreComparison = right.getGenre().compareTo(left.getGenre());
                if (genreComparison != 0) {
                    return genreComparison;
                }
                return Double.compare(right.getPrice(), left.getPrice());
            }
        });
        return sortedList;
    }

    /**
     * Sắp xếp sách theo giá tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, Comparator.comparingDouble(Book::getPrice));
        return sortedList;
    }

    /**
     * Sắp xếp sách theo giá giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, Comparator.comparingDouble(Book::getPrice).reversed());
        return sortedList;
    }

    /**
     * Sắp xếp sách theo số trang tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPages() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, Comparator.comparingInt(Book::getPages));
        return sortedList;
    }

    /**
     * Sắp xếp sách theo số trang giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPages() {
        List<Book> sortedList = new LinkedList<>(bookList);
        Collections.sort(sortedList, Comparator.comparingInt(Book::getPages).reversed());
        return sortedList;
    }

    /**
     * Lọc ra howMany sách có số trang lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPages(int howMany) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getPages).reversed())
                .limit(howMany)
                .collect(Collectors.toList());
    }

    /**
     * Lọc ra những sách có số trang cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPagesHigherThan(double lowerBound) {
        return bookList.stream()
                .filter(book -> book.getPages() > lowerBound)
                .collect(Collectors.toList());
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getPages))
                .limit(howMany)
                .collect(Collectors.toList());
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        return bookList.stream()
                .filter(book -> book.getPages() < upperBound)
                .collect(Collectors.toList());
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        return bookList.stream()
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        return bookList.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
