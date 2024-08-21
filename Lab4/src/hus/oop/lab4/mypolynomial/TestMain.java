package hus.oop.lab4.mypolynomial;

public class TestMain {

    public static void main(String[] args) {
        double[] coeffs = { 1.1, 2.2, 3.3, 4.4 };
        MyPolynomial polynomial1 = new MyPolynomial(coeffs);

        System.out.println(polynomial1);
        System.out.println("polynomial1's degree: " + polynomial1.getDegree());

        double[] coeffs1 = { 1, 2, 3, 4, 5 };

        System.out.println(polynomial1.add(new MyPolynomial(coeffs1)));
        System.out.println(polynomial1.multiply(new MyPolynomial(coeffs1)));
        System.out.println(polynomial1.evaluate(2));
    }
}

