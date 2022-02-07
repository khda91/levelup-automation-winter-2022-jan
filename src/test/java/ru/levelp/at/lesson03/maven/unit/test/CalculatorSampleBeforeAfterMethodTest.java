package ru.levelp.at.lesson03.maven.unit.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorSampleBeforeAfterMethodTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        System.out.println(this.getClass().getCanonicalName() + "#setUp");
        calculator = new Calculator();
    }

    @Test
    public void testCalculatorSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSum");
        int actualResult = calculator.sum(2, 2);
        Assertions.assertEquals(4, actualResult);
    }

    @Test
    public void testCalculatorSubtract() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSubtract");
        int actualResult = calculator.subtract(2, 2);
        Assertions.assertEquals(0, actualResult);
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println(this.getClass().getCanonicalName() + "#tearDown");
    }
}
