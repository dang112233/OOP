package hus.oop.lab4.account;

public class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        return this.balance = amount + balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            return balance = balance - amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount <= balance) {
            another.credit(amount);
            return this.balance = balance - amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account[" +
                "id = " + id +
                ", name = " + name +
                ", balance = " + balance +
                ']';
    }
}
