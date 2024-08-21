package oop.lab10.strategy.sort;

import java.util.Arrays;

public class Context {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] numbers) {
        strategy.sort(numbers);
        System.out.println("Result: " + Arrays.toString(numbers));
    }
}