package hus.oop.lab9.poly;

public interface Poly {
    int degree();
    Poly derivative();
    double coefficient(int degree);
    double[] coefficients();
}
