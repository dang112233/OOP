package hus.oop.lab4.customer.account;

public class TestMain {
    public static void main(String[] args) {
        // Test constructor and toString()
        Customer customer1 = new Customer(10, " Tan Ah ", 'm');
        Account account1 = new Account(100, customer1, 999);

        System.out.println(customer1);
        System.out.println(account1);

        // Test deposit() and withdraw()
        account1.deposit(100);
        System.out.println(account1);
        account1.withdraw(500);
        System.out.println(account1);
    }
}

