package oop.lab10.strategy.sort;

public class SelectionSort implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (numbers[j] < numbers[min_idx])
                    min_idx = j;

            int temp = numbers[min_idx];
            numbers[min_idx] = numbers[i];
            numbers[i] = temp;
        }
    }
}
