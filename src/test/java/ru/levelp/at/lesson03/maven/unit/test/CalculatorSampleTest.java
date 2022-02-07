package ru.levelp.at.lesson03.maven.unit.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorSampleTest {

    @Test
    public void testCalculatorSum() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.sum(2, 2);
        Assertions.assertEquals(4, actualResult);
    }

    @Test
    public void testCalculatorSubtract() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.subtract(2, 2);
        Assertions.assertEquals(0, actualResult);
    }
}
