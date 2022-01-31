package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test
    public void testCalculatorSubtract() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSubtract");
        int actualResult = calculator.subtract(2, 2);
        Assert.assertEquals(actualResult, 0);
    }

}
