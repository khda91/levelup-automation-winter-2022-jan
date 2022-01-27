package ru.levelp.at.lesson02.git;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("sum 2 + 2 = " + calculator.sum(2, 2));
        System.out.println("======");
        System.out.println(String.format("subtract 4 - 5 = %d", calculator.subtract(4, 5)));
        System.out.println("======");
        System.out.println(String.format("5! = %d", calculator.factorial(5)));
        System.out.println("======");
        System.out.println(String.format("2 in 10 power is %d", calculator.power(2, 10)));
        System.out.println("======");
        System.out.println("divide 4 / 2 = " + calculator.divide(4, 2));
    }
}
