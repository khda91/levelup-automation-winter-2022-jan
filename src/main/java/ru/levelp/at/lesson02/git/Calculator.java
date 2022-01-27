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

    public long factorial(long a) {
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}
