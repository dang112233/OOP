package hus.oop.lab11.factorymethod.example;

public class BankTransferPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Bank transfer payment of $" + amount + " is processed");
    }
}
