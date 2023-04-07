package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double rvs(int a) {
        if (a == 0) {
            throw new IllegalArgumentException("Bad Input!");
        }
        return (double)1/a;
    }

    public double sqr(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Bad Input!");
        }
        return Math.sqrt ( a );
    }
}
