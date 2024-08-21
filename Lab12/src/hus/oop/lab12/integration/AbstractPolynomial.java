package hus.oop.lab12.integration;

public abstract class AbstractPolynomial implements Polynomial {

    @Override
    public String toString() {
        double[] coefficients = coefficients();
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0 && coefficients[i] > 0) {
                    sb.append(" + ");
                } else if (coefficients[i] < 0) {
                    sb.append(" - ");
                }
                sb.append(Math.abs(coefficients[i]));
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override
    public double[] differentiate() {
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[]{0};
        }
        double[] derivative = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derivative[i - 1] = i * coeffs[i];
        }
        return derivative;
    }
}
