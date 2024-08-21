package hus.oop.statistics;

import java.util.ArrayList;
import java.util.List;

public class ListDataSet extends AbstractDataSet {
    private List<Double> data;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public ListDataSet() {
        /* TODO */
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return data.size();
    }

    @Override
    public double elementAt(int index) {
        /* TODO */
        return data.get(index);
    }

    @Override
    public double[] elements(int from, int to) {
        /* TODO */
        int size = to - from + 1;
        double[] elements = new double[size];
        for (int i = 0; i < size; i++) {
            elements[i] = data.get(from + i);
        }
        return elements;
    }

    @Override
    public void insertAtStart(double data) {
        appendAtStart(data);
    }

    @Override
    public void insertAtEnd(double data) {
        appendAtEnd(data);
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void appendAtStart(double value) {
        /* TODO */
        data.add(0, value);
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void appendAtEnd(double value) {
        /* TODO */
        data.add(value);
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     *
     * @param index
     * @param value
     */
    @Override
    public void insertAtPosition(int index, double value) {
        /* TODO */
        data.add(index, value);
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        data.remove(index);
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     *
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
        data.removeIf(v -> v == value);
    }
}
