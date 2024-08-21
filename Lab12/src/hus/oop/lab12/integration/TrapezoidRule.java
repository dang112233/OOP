package hus.oop.lab12.integration;

public class TrapezoidRule implements Integrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        int n0 = 10;
        double I_n = integrate(poly, lower, upper, n0);
        double I_2n = integrate(poly, lower, upper, 2 * n0);
        int iterations = 1;

        while (Math.abs(I_2n - I_n) / 3 > precision && iterations < maxIterations) {
            n0 *= 2;
            I_n = I_2n;
            I_2n = integrate(poly, lower, upper, 2 * n0);
            iterations++;
        }

        return I_2n;
    }

    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double sum = (poly.evaluate(lower) + poly.evaluate(upper)) / 2;

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            sum += poly.evaluate(x);
        }

        return sum * h;
    }
}
