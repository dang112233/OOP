package hus.oop.lab5;

public class TestMyPolynomial {

    public static void main(String[] args) {
        double[] coeffs1 = new double[]{1.9, 0, 5.3, 2, 7.6};
        MyPolynomial myPolynomial1 = new MyPolynomial(coeffs1);

        System.out.println(myPolynomial1.toString());
        System.out.println(myPolynomial1.evaluate(2));

        double[] coeffs2 = new double[] {1.1, 2.2, 3.3, 4.4};
        MyPolynomial myPolynomial2 = new MyPolynomial(coeffs2);

        System.out.println(myPolynomial2.toString());
        System.out.println(myPolynomial1.add(myPolynomial2));
        System.out.println(myPolynomial1.multiply(myPolynomial2));
    }
}
