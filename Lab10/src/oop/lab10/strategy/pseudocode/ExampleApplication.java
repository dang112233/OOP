package oop.lab10.strategy.pseudocode;

import java.util.Scanner;

public class ExampleApplication {
    public static void main(String[] args) {
        Context context = new Context();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter second number:");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter action (addition, subtraction, multiplication):");
        String action = scanner.next();

        if (action.equals("addition")) {
            context.setStrategy(new ConcreteStrategyAdd());
        } else if (action.equals("subtraction")) {
            context.setStrategy(new ConcreteStrategySubtract());
        } else if (action.equals("multiplication")) {
            context.setStrategy(new ConcreteStrategyMultiply());
        }

        int result = context.executeStrategy(firstNumber, secondNumber);
        System.out.println("Result: " + result);
    }
}

