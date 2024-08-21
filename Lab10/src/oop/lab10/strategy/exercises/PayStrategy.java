package oop.lab10.strategy.exercises;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
