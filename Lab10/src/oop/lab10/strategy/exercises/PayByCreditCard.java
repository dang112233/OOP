package oop.lab10.strategy.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private static PayByCreditCard instance = null;
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    private PayByCreditCard() {
    }

    public static PayByCreditCard getInstance() {
        if (instance == null) {
            instance = new PayByCreditCard();
        }
        return instance;
    }

    /**
     * Collect credit card data.
     */

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the card number: ");
            String number = READER.readLine();
            System.out.print("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Enter the Card Verification Value code: ");
            String cardVerificationValue = READER.readLine();
            if (CreditCardValidator.isValid(number)) {
                card = CreditCard.getInstance(number, date, cardVerificationValue);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * After card validation, we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
        return false;
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}