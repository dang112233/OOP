package hus.oop.lab12.mylist;

public class MyArrayListIterator implements MyIterator {
    private Object[] data;
    private int currentPosition;
    private int size;

    /**
     * Khởi tạo dữ liệu cho Iterator bằng dữ liệu của MyArrayList để nó có thể duyệt qua các phần tử dữ liệu
     * của MyArrayList.
     * @param data
     * @param size
     */
    public MyArrayListIterator(Object[] data, int size) {
        this.data = data;
        this.size = size;
        this.currentPosition = 0;
    }

    /**
     * Kiểm tra trong MyArrayList có còn phần tử tiếp theo không.
     * Nếu còn thì trả về true, nếu không còn thì trả về false.
     * @return
     */
    @Override
    public boolean hasNext() {
        return currentPosition < size;
    }

    /**
     * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra phần tử hiện tại của MyArrayList.
     * @return phần tử hiện tại.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return data[currentPosition++];
    }
}
