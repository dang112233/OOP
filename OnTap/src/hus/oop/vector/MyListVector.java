package hus.oop.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] coords = new double[size()];
        for (int i = 0; i < size(); i++) {
            coords[i] = data.get(i);
        }
        return coords;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data.set(index, value);
    }

    @Override
    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector add(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d + value);
        }
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.insert(this.coordinate(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        for (int i = 0; i < size(); i++) {
            set(coordinate(i) + value, i);
        }
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        for (int i = 0; i < size(); i++) {
            set(coordinate(i) + another.coordinate(i), i);
        }
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d - value);
        }
        return result;
    }

    @Override
    public MyListVector minus(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.insert(this.coordinate(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        for (int i = 0; i < size(); i++) {
            set(coordinate(i) - value, i);
        }
        return this;
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        for (int i = 0; i < size(); i++) {
            set(coordinate(i) - another.coordinate(i), i);
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (this.size() != another.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        double result = 0.0;
        for (int i = 0; i < size(); i++) {
            result += this.coordinate(i) * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyListVector pow(double power) {
        for (int i = 0; i < size(); i++) {
            set(Math.pow(coordinate(i), power), i);
        }
        return this;
    }

    @Override
    public MyListVector scale(double value) {
        for (int i = 0; i < size(); i++) {
            set(coordinate(i) * value, i);
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0.0;
        for (double d : data) {
            sum += d * d;
        }
        return Math.sqrt(sum);
    }

    @Override
    public MyListVector extract(int[] indices) {
        MyListVector result = new MyListVector();
        for (int index : indices) {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            result.insert(coordinate(index));
        }
        return result;
    }
}
