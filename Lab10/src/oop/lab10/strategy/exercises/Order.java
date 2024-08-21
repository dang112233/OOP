package oop.lab10.strategy.exercises;

/**
 * Order class. Doesn’t know the concrete payment method (strategy) user has picked.
 * It uses common strategy interface to delegate collecting payment data to strategy object.
 * It can be used to save order to database.
 */
public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrderUsingPaypal(PayByPaypal paypal) {
        paypal.collectPaymentDetails();
    }

    public void processOrderUsingCreditCard(PayByCreditCard creditCard) {
        creditCard.collectPaymentDetails();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}


