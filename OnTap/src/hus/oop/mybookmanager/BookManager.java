package hus.oop.mybookmanager;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        bookList = new MyLinkedList(); // Initialize with a linked list implementation
    }

    public static synchronized BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAtPosition(Book book, int index) {
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        return (Book) bookList.iterator().next();
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        if (bookList.size() == 0) return null;

        MyIterator iterator = bookList.iterator();
        Book highest = (Book) iterator.next();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getPrice() > highest.getPrice()) {
                highest = current;
            }
        }
        return highest;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        if (bookList.size() == 0) return null;

        MyIterator iterator = bookList.iterator();
        Book lowest = (Book) iterator.next();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getPrice() < lowest.getPrice()) {
                lowest = current;
            }
        }
        return lowest;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;

        MyIterator iterator = bookList.iterator();
        Book highest = (Book) iterator.next();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getPages() > highest.getPages()) {
                highest = current;
            }
        }
        return highest;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;

        MyIterator iterator = bookList.iterator();
        Book lowest = (Book) iterator.next();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getPages() < lowest.getPages()) {
                lowest = current;
            }
        }
        return lowest;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        MyList result = new MyLinkedList();
        MyIterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getPublisher().equals(publisher)) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        MyList result = new MyLinkedList();
        MyIterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getGenre().equals(genre)) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        MyList result = new MyLinkedList();
        MyIterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book current = (Book) iterator.next();
            if (current.getAuthor().equals(author)) {
                result.insertAtEnd(current);
            }
        }
        return result;
    }
}
