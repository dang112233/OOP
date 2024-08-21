package hus.oop.lab11.factorymethod.example;

public class BankTransferPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new BankTransferPayment();
    }
}
