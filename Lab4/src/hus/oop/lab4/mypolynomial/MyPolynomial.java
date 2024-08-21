package hus.oop.lab4.mypolynomial;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        if (coeffs == null)
            return 0;
        return coeffs.length - 1;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < coeffs.length - 1; i++) {
            result.append(coeffs[i] + "x^" + (this.coeffs.length - i - 1) + " + ");
        }
        result.append(this.coeffs[this.coeffs.length - 1]);
        return result.toString();
    }

    public double evaluate(double x) {
        double pValue = 0.0;
        for (int i = coeffs.length - 1; i >= 1; i--) {
            pValue = (pValue + coeffs[i]) * x;
        }
        return pValue + coeffs[0];
    }

    public MyPolynomial add(MyPolynomial right) {
        if (this.coeffs.length < right.coeffs.length) {
            for (int i = 0; i < coeffs.length; i++)
                right.coeffs[i] += coeffs[i];
            coeffs = right.coeffs;
        } else {
            for (int i = 0; i < right.coeffs.length; i++)
                coeffs[i] += right.coeffs[i];
        }
        return this;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] newCoeffs = new double[coeffs.length * right.coeffs.length];
        for (int i = 0; i < coeffs.length; i++)
            for (int j = 0; j < right.coeffs.length; j++)
                newCoeffs[i + j] += coeffs[i] * right.coeffs[j];
        coeffs = newCoeffs;
        return this;
    }
}
