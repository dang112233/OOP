package hus.oop.lab12.integration;

import hus.oop.integration.*;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        testArrayPolynomial();
        testListPolynomial();
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        ArrayPolynomial poly1 = new ArrayPolynomial()
                .append(1.0)
                .append(2.0)
                .append(3.0);

        System.out.println("Array Polynomial: " + poly1);
        System.out.println("Degree: " + poly1.degree());
        System.out.println("Evaluate at x=2: " + poly1.evaluate(2));

        ArrayPolynomial poly2 = new ArrayPolynomial()
                .append(3.0)
                .append(4.0);

        System.out.println("Array Polynomial 2: " + poly2);
        System.out.println("Sum: " + poly1.plus(poly2));
        System.out.println("Difference: " + poly1.minus(poly2));
        System.out.println("Product: " + poly1.multiply(poly2));
    }

    public static void testListPolynomial() {
        ListPolynomial poly1 = new ListPolynomial()
                .append(1.0)
                .append(2.0)
                .append(3.0);

        System.out.println("List Polynomial: " + poly1);
        System.out.println("Degree: " + poly1.degree());
        System.out.println("Evaluate at x=2: " + poly1.evaluate(2));

        ListPolynomial poly2 = new ListPolynomial()
                .append(3.0)
                .append(4.0);

        System.out.println("List Polynomial 2: " + poly2);
        System.out.println("Sum: " + poly1.plus(poly2));
        System.out.println("Difference: " + poly1.minus(poly2));
        System.out.println("Product: " + poly1.multiply(poly2));
    }

    public static void testIntegrationCalculator() {
        ArrayPolynomial poly = new ArrayPolynomial()
                .append(1.0)
                .append(2.0)
                .append(3.0);

        System.out.println("Midpoint Rule: " + calculateIntegral(new MidpointRule(), poly, 0, 2));
        System.out.println("Trapezoid Rule: " + calculateIntegral(new TrapezoidRule(), poly, 0, 2));
        System.out.println("Simpson Rule: " + calculateIntegral(new SimpsonRule(), poly, 0, 2));
    }

    public static double calculateIntegral(Integrator integrator, Polynomial poly, double lower, double upper) {
        IntegrationCalculator calculator = new IntegrationCalculator(integrator, poly);
        return calculator.integrate(lower, upper);
    }
}
