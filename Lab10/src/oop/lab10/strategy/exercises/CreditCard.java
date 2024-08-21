package oop.lab10.strategy.exercises;

/**
 * Dummy credit card class.
 */
public class CreditCard {
    private static CreditCard instance = null;
    private int amount;
    private final String number;
    private final String date;
    private final String cardVerificationValue;

    private CreditCard(String number, String date, String cardVerificationValue) {
        this.amount = 100000;
        this.number = number;
        this.date = date;
        this.cardVerificationValue = cardVerificationValue;
    }

    public static CreditCard getInstance(String number, String date, String cardVerificationValue) {
        if (instance == null) {
            instance = new CreditCard(number, date, cardVerificationValue);
        }
        return instance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return this.number;
    }
}


