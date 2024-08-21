package hus.oop.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        return MyMath.sin(x) * x - 3;
    }

    @Override
    public double derivative(double x) {
        /* TODO */
        return MyMath.cos(x) * x + MyMath.sin(x);
    }
}
