package hus.oop.search;

public class BinarySearch implements Search {
    private static BinarySearch instance;
    private Sorter sorter;

    private BinarySearch() {
        // private constructor to prevent instantiation
    }

    /**
     * Tạo đối tượng BinarySearch.
     * @return instance of BinarySearch
     */
    public static BinarySearch getInstance() {
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == value) {
                return mid;
            }

            if (data[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // value not found
    }

    private void sort(double[] data) {
        if (sorter != null) {
            sorter.sort(data, true);
        }
    }
}