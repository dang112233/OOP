package hus.oop.lab5;

import java.math.BigInteger;

public class TestBigInteger {

    public static void main(String[] args) {

        BigInteger num1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
        BigInteger num2 = new BigInteger("22222222222222222222222222222222222222222222222222");

        BigInteger sum = num1.add(num2);
        System.out.println("The sum of the two numbers is: " + sum);

        BigInteger product = num1.multiply(num2);
        System.out.println("The product of the two numbers is: " + product);
    }
}

