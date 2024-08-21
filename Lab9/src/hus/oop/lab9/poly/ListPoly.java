package hus.oop.lab9.poly;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    List<Double> coefficients;

    public ListPoly(double[] coeffs) {
        coefficients = new ArrayList<>();
        for (double coeff : coeffs) {
            coefficients.add(coeff);
        }
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public Poly derivative() {
        List<Double> derivativeCoeffs = new ArrayList<>();
        for (int i = 1; i < coefficients.size(); i++) {
            derivativeCoeffs.add(coefficients.get(i) * i);
        }
        return new ListPoly(derivativeCoeffs.stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Override
    public double coefficient(int degree) {
        if (degree >= 0 && degree < coefficients.size()) {
            return coefficients.get(degree);
        }
        return 0.0;
    }

    @Override
    public double[] coefficients() {
        return coefficients.stream().mapToDouble(Double::doubleValue).toArray();
    }
}

