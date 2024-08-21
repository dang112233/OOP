package hus.oop.lab12.integration;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficients;
    private int size;

    public ArrayPolynomial() {
        this.coefficients = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return coefficients[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficients, 0, result, 0, size);
        return result;
    }

    public ArrayPolynomial append(double coefficient) {
        if (size == coefficients.length) {
            enlarge();
        }
        coefficients[size++] = coefficient;
        return this;
    }

    public ArrayPolynomial insert(double coefficient, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (size == coefficients.length) {
            enlarge();
        }
        System.arraycopy(coefficients, index, coefficients, index + 1, size - index);
        coefficients[index] = coefficient;
        size++;
        return this;
    }

    public ArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        coefficients[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = size - 1; i >= 0; i--) {
            result = result * x + coefficients[i];
        }
        return result;
    }

    @Override
    public Polynomial derivative() {
        double[] derivativeCoeffs = differentiate();
        ArrayPolynomial derivative = new ArrayPolynomial();
        for (double coeff : derivativeCoeffs) {
            derivative.append(coeff);
        }
        return derivative;
    }

    public ArrayPolynomial plus(ArrayPolynomial another) {
        int maxDegree = Math.max(this.degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double coeff = (i <= this.degree() ? this.coefficient(i) : 0) + (i <= another.degree() ? another.coefficient(i) : 0);
            result.append(coeff);
        }
        return result;
    }

    public ArrayPolynomial minus(ArrayPolynomial another) {
        int maxDegree = Math.max(this.degree(), another.degree());
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double coeff = (i <= this.degree() ? this.coefficient(i) : 0) - (i <= another.degree() ? another.coefficient(i) : 0);
            result.append(coeff);
        }
        return result;
    }

    public ArrayPolynomial multiply(ArrayPolynomial another) {
        int newDegree = this.degree() + another.degree();
        ArrayPolynomial result = new ArrayPolynomial();
        for (int i = 0; i <= newDegree; i++) {
            result.append(0);
        }
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                result.coefficients[i + j] += this.coefficients[i] * another.coefficients[j];
            }
        }
        result.size = newDegree + 1;
        return result;
    }

    private void enlarge() {
        double[] newCoefficients = new double[coefficients.length * 2];
        System.arraycopy(coefficients, 0, newCoefficients, 0, coefficients.length);
        coefficients = newCoefficients;
    }
}
