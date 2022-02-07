package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test(groups = "positive")
    public void testCalculatorSubtract() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSubtract");
        int actualResult = calculator.subtract(2, 2);
        Assert.assertEquals(actualResult, 0);
    }

}
