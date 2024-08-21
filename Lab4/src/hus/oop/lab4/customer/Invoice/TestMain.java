package hus.oop.lab4.customer.Invoice;

public class TestMain {

    public static void main(String[] args) {
        // Test Customer class
        Customer customer1 = new Customer(88, "Tan Ah Tek", 10);
        System.out.println(customer1);

        customer1.setDiscount(8);
        System.out.println(customer1);

        // Test Invoice class
        Invoice invoice1 = new Invoice(101, customer1, 888.8);
        System.out.println(invoice1);

        invoice1.setAmount(999.9);
        System.out.println(invoice1);
        System.out.println("customer's id is: " + invoice1.getCustomerId());
        System.out.println("customer's name is: " + invoice1.getCustomerName());
        System.out.println("customer's discount is: " + invoice1.getCustomerDiscount());
        System.out.printf("amount after discount is: %.2f%n", invoice1.getAmountAfterDiscount());
    }
}
