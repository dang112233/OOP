package hus.oop.lab12.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    public ListPolynomial() {
        this.coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    public ListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    public ListPolynomial insert(double coefficient, int index) {
        if (index < 0 || index > coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        coefficients.add(index, coefficient);
        return this;
    }

    public ListPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public Polynomial derivative() {
        double[] derivativeCoeffs = differentiate();
        ListPolynomial derivative = new ListPolynomial();
        for (double coeff : derivativeCoeffs) {
            derivative.append(coeff);
        }
        return derivative;
    }

    public ListPolynomial plus(ListPolynomial another) {
        int maxDegree = Math.max(this.degree(), another.degree());
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double coeff = (i <= this.degree() ? this.coefficient(i) : 0) + (i <= another.degree() ? another.coefficient(i) : 0);
            result.append(coeff);
        }
        return result;
    }

    public ListPolynomial minus(ListPolynomial another) {
        int maxDegree = Math.max(this.degree(), another.degree());
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double coeff = (i <= this.degree() ? this.coefficient(i) : 0) - (i <= another.degree() ? another.coefficient(i) : 0);
            result.append(coeff);
        }
        return result;
    }

    public ListPolynomial multiply(ListPolynomial another) {
        int newDegree = this.degree() + another.degree();
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i <= newDegree; i++) {
            result.append(0.0);
        }
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                result.coefficients.set(i + j, result.coefficients.get(i + j) + this.coefficients.get(i) * another.coefficients.get(j));
            }
        }
        return result;
    }
}
