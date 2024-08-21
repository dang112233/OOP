package hus.oop.lab11.factorymethod.example;

public class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal payment of $" + amount + " is processed");
    }
}
