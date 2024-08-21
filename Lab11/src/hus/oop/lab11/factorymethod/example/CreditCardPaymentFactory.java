package hus.oop.lab11.factorymethod.example;

public class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
