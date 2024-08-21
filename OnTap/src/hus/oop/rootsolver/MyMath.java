package hus.oop.rootsolver;

public class MyMath {

    // Helper function to calculate factorial of a number
    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Taylor series approximation for sine function
    public static double sin(double x) {
        double result = 0;
        int n = 10; // Number of terms in the Taylor series

        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / factorial(2 * i + 1);
            result += term;
        }

        return result;
    }

    // Taylor series approximation for cosine function
    public static double cos(double x) {
        double result = 0;
        int n = 10; // Number of terms in the Taylor series

        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * Math.pow(x, 2 * i) / factorial(2 * i);
            result += term;
        }

        return result;
    }

    // Taylor series approximation for exponential function
    public double exp(double x) {
        double result = 0;
        int n = 20; // Number of terms in the Taylor series

        for (int i = 0; i < n; i++) {
            double term = Math.pow(x, i) / factorial(i);
            result += term;
        }

        return result;
    }

    // Taylor series approximation for natural logarithm (ln) function
    public double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Input must be greater than 0");
        }

        // Using the series expansion ln(x) = 2 * sum((z^(2n + 1)) / (2n + 1)) for z = (x - 1) / (x + 1)
        double z = (x - 1) / (x + 1);
        double result = 0;
        int n = 20; // Number of terms in the Taylor series

        for (int i = 0; i < n; i++) {
            double term = Math.pow(z, 2 * i + 1) / (2 * i + 1);
            result += term;
        }

        return 2 * result;
    }
}
