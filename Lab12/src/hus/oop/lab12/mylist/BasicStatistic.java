package hus.oop.lab12.mylist;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        double max = Double.NEGATIVE_INFINITY;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            double value = (Double) iterator.next();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        double min = Double.POSITIVE_INFINITY;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            double value = (Double) iterator.next();
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        double sum = 0;
        int count = 0;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            sum += (Double) iterator.next();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        double mean = mean();
        double sum = 0;
        int count = 0;
        MyIterator iterator = data.iterator();
        while (iterator.hasNext()) {
            double value = (Double) iterator.next();
            sum += Math.pow(value - mean, 2);
            count++;
        }
        return sum / count;
    }
}
