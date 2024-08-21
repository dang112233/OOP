package hus.oop.vector;

import java.util.Arrays;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + value);
        }
        return result;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(this.coordinate(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector addTo(double value) {
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.coordinate(i);
        }
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - value);
        }
        return result;
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(this.coordinate(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        for (int i = 0; i < size; i++) {
            data[i] -= value;
        }
        return this;
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        for (int i = 0; i < size; i++) {
            data[i] -= another.coordinate(i);
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += this.coordinate(i) * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyArrayVector pow(double power) {
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    @Override
    public MyArrayVector scale(double value) {
        for (int i = 0; i < size; i++) {
            data[i] *= value;
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    @Override
    public MyArrayVector insert(double value) {
        if (size == data.length) {
            enlarge();
        }
        data[size++] = value;
        return this;
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == data.length) {
            enlarge();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        MyArrayVector result = new MyArrayVector();
        for (int index : indices) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            result.insert(data[index]);
        }
        return result;
    }

    /**
     * Mở rộng kích  thước vector lên gấp đôi khi cần thiết.
     * @return vector hiện tại.
     */
    private MyArrayVector enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
        return this;
    }
}
