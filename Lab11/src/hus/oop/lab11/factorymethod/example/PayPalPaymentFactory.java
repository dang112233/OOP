package hus.oop.lab11.factorymethod.example;

public class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}
