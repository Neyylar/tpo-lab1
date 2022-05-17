package ru.itmo.tpo.task1;

public class TaylorArccos {
    private final int N;

    public TaylorArccos(int n) {
        this.N = n;
    }

    private int factorial(int N) {
        if (N == 0) return 1;
        if (N <= 2) return N;
        return N * factorial(N - 1);

    }

    public double arccos(double arg) throws SmallNException, ArgOutOfBorderException, BigNException {
        double result = 0;
        boolean shift = true;
        boolean neg = false;
        if (Math.abs(arg) > 0.99) {
            if (arg < 0) neg = true;
            arg = Math.sqrt(1 - arg * arg);
            shift = false;
        }
        if (Math.abs(arg) > 1 || Double.isNaN(arg)) { throw new ArgOutOfBorderException("Argument should be less than 1 and more than -1 for arccos"); }
        if (N < 3) { throw new SmallNException("N should be more than 3"); }
        if (N > 30) { throw new BigNException("Too big N"); }
        for (int i = 0; i < N; i++) {
            double step_result = factorial(2 * i) * Math.pow(arg, 2 * i + 1) / (Math.pow(4, i) * Math.pow(factorial(i), 2) * (2 * i + 1));
            result += step_result; }
        if (shift) result = Math.PI / 2 - result;
        if (neg) result = Math.PI + result;
        return result;
    }
}

