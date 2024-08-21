package hus.oop.statistics;

import java.util.Arrays;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistic() {
        /* TODO */
        this.dataSet = dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        /* TODO */
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        /* TODO */
        return dataSet.size();
    }

    @Override
    public double max() {
        /* TODO */
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Dataset is empty");
        }
        double max = dataSet.elementAt(0);
        for (int i = 1; i < size; i++) {
            double value = dataSet.elementAt(i);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public double min() {
        /* TODO */
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Dataset is empty");
        }
        double min = dataSet.elementAt(0);
        for (int i = 1; i < size; i++) {
            double value = dataSet.elementAt(i);
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public double mean() {
        /* TODO */
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Dataset is empty");
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += dataSet.elementAt(i);
        }
        return sum / size;
    }

    @Override
    public double variance() {
        /* TODO */
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Dataset is empty");
        }
        double mean = mean();
        double sumSquaredDiff = 0;
        for (int i = 0; i < size; i++) {
            double diff = dataSet.elementAt(i) - mean;
            sumSquaredDiff += diff * diff;
        }
        return sumSquaredDiff / size;
    }

    @Override
    public double[] rank() {
        /* TODO */
        int size = dataSet.size();
        double[] sortedData = new double[size];
        for (int i = 0; i < size; i++) {
            sortedData[i] = dataSet.elementAt(i);
        }
        Arrays.sort(sortedData);
        return sortedData;
    }

    @Override
    public double median() {
        /* TODO */
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Dataset is empty");
        }
        double[] sortedData = rank();
        if (size % 2 == 0) {
            // If even number of elements, return average of middle two
            int midIndex1 = size / 2 - 1;
            int midIndex2 = size / 2;
            return (sortedData[midIndex1] + sortedData[midIndex2]) / 2;
        } else {
            // If odd number of elements, return middle element
            return sortedData[size / 2];
        }
    }
}
