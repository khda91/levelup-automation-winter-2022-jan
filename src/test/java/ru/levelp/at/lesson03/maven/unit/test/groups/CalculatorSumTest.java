package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends CalculatorBaseTest {

    @Test(groups = "positive")
    public void testCalculatorSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSum");
        int actualResult = calculator.sum(2, 2);
        Assert.assertEquals(actualResult, 4);
    }

}
