package hus.oop.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x = (lower + upper) / 2.0;  // Initial guess
        for (int i = 0; i < maxIterations; i++) {
            double fValue = function.evaluate(x);
            double derivative = derivative(function, x);

            if (Math.abs(derivative) < tolerance) {
                throw new ArithmeticException("Derivative is too small.");
            }

            double xNext = x - fValue / derivative;
            if (Math.abs(xNext - x) < tolerance) {
                return xNext;
            }
            x = xNext;
        }

        throw new ArithmeticException("Maximum number of iterations exceeded.");
    }

    private double derivative(AbstractFunction function, double x) {
        double h = 1e-6;
        return (function.evaluate(x + h) - function.evaluate(x - h)) / (2 * h);
    }
}
