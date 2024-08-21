package hus.oop.lab5;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String polynomial = "";
        for (int i = this.getDegree(); i >= 1; i--)
            if (coeffs[i] != 0) {
                polynomial += String.format("%fx^%d + ", coeffs[i], i);
            }
        polynomial += String.format(" %f", coeffs[0]);
        return polynomial;
    }

    public double evaluate(double x) {
        double result = coeffs[this.getDegree()];
        for (int i = this.getDegree() - 1; i >= 1; i--) {
            result = x * result + coeffs[i - 1];
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] resultCoeffs = new double[Math.max(this.getDegree(), right.getDegree()) +1];
        for (int i = 0; i < resultCoeffs.length; i++) {
            if (i <= Math.min(this.getDegree(), right.getDegree())) {
                resultCoeffs[i] += (this.coeffs[i] + right.coeffs[i]);
            } else if (this.getDegree() < right.getDegree()) {
                resultCoeffs[i] = right.coeffs[i];
            } else {
                resultCoeffs[i] = this.coeffs[i];
            }
        }
        return new MyPolynomial(resultCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] resultCoeff = new double[this.getDegree() + right.getDegree() + 1];
        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= right.getDegree(); j++){
                resultCoeff[i+j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(resultCoeff);
    }
}

