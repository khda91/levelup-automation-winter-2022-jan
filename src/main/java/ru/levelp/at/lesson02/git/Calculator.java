package ru.levelp.at.lesson02.git;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public int power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("b cannot be negative.");
        }

        int result = 1;

        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public long factorial(long a) {
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public double cos(double a) {
        return Math.cos(a);
    }

    public double tanh(double a) {
        return Math.tanh(a);
    }

}
