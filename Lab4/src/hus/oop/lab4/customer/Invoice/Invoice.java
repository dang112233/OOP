package hus.oop.lab4.customer.Invoice;

public class Invoice {
    private final int id;
    private final Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        return amount * (100 - customer.getDiscount()) / 100;
    }

    @Override
    public String toString() {
        return "Invoice[" +
                "id = " + id +
                ", customer = " + customer +
                ", amount = " + amount +
                ']';
    }
}

