package hus.oop.statistics;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Mô tả tập dữ liệu.
     *
     * @return mô tả tập dữ liệu dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(elementAt(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public abstract void appendAtStart(double value);

    public abstract void appendAtEnd(double value);
}
