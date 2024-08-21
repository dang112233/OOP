package hus.oop.statistics;

import java.util.Arrays;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        /* TODO */
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double elementAt(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    @Override
    public double[] elements(int from, int to) {
        /* TODO */
        if (from < 0 || to >= size || from > to) {
            throw new IllegalArgumentException("Invalid range");
        }
        return Arrays.copyOfRange(data, from, to + 1);
    }

    /**
     * Thêm phần tử dữ liệu vào đầu mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(double value) {
        /* TODO */
        if (size == data.length) {
            allocateMore();
        }
        System.arraycopy(data, 0, data, 1, size);
        data[0] = value;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(double value) {
        /* TODO */
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param index
     * @param value
     */
    @Override
    public void insertAtPosition(int index, double value) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == data.length) {
            allocateMore();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                remove(i);
                i--; // Recheck the current index after removal
            }
        }
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        /* TODO */
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public void appendAtStart(double value) {
        insertAtStart(value);
    }

    @Override
    public void appendAtEnd(double value) {
        insertAtEnd(value);
    }
}
