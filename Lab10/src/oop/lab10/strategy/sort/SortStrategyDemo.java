package oop.lab10.strategy.sort;

import java.util.Arrays;

public class SortStrategyDemo {
    public static void main(String[] args) {
        Context context = new Context();

        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        context.setStrategy(new BubbleSort());
        context.executeStrategy(numbers.clone());
        System.out.println("Bubble sorted array: " + Arrays.toString(numbers));

        context.setStrategy(new SelectionSort());
        context.executeStrategy(numbers.clone());
        System.out.println("Selection sorted array: " + Arrays.toString(numbers));

        context.setStrategy(new InsertionSort());
        context.executeStrategy(numbers.clone());
        System.out.println("Insertion sorted array: " + Arrays.toString(numbers));
    }
}