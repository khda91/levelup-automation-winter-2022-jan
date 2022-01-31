package ru.levelp.at.lesson03.maven.unit.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSampleTest {

    @Test
    public void testCalculatorSum() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.sum(2, 2);
        Assert.assertEquals(actualResult, 4);
    }

    @Test
    public void testCalculatorSubtract() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.subtract(2, 2);
        Assert.assertEquals(actualResult, 0);
    }

}
