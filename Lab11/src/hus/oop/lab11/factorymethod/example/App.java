package hus.oop.lab11.factorymethod.example;

public class App {
    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.processPayment(150.00);

        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        Payment payPalPayment = payPalFactory.createPayment();
        payPalPayment.processPayment(250.00);

        PaymentFactory bankTransferFactory = new BankTransferPaymentFactory();
        Payment bankTransferPayment = bankTransferFactory.createPayment();
        bankTransferPayment.processPayment(350.00);
    }
}
