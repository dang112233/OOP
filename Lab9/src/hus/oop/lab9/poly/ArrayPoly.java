package hus.oop.lab9.poly;

public class ArrayPoly extends AbstractPoly {
    private final double[] coefficients;

    public ArrayPoly(double[] coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public int degree() {
        return coefficients.length - 1;
    }

    @Override
    public Poly derivative() {
        double[] derivativeCoefficients = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            derivativeCoefficients[i - 1] = coefficients[i] * i;
        }
        return new ArrayPoly(derivativeCoefficients);
    }

    @Override
    public double coefficient(int degree) {
        if (degree < 0 || degree >= coefficients.length) {
            return 0;
        }
        return coefficients[degree];
    }

    @Override
    public double[] coefficients() {
        return coefficients;
    }
}

