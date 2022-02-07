package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorPowerTest extends CalculatorBaseTest {

    @BeforeMethod(groups = {"positive", "negative"})
    @Override
    public void setUp() {
        super.setUp();
        System.out.println("this method was override");
    }

    @Test(groups = {"positive"})
    public void testCalculatorPower() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPower");
        int actualResult = calculator.power(2, 10);
        Assert.assertEquals(actualResult, 1024);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
          groups = "negative")
    public void testCalculatorPowerNegative() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPowerNegative");
        calculator.power(2, -2);
    }

    @Test(groups = "negative")
    public void testCalculatorPowerNegativeAssertThrows() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPowerNegativeAssertThrows");
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.power(2, -2));
    }

    @Test(groups = "negative")
    public void testCalculatorPowerNotEquals() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPowerNotEquals");
        int actualResult = calculator.power(2, 0);
        Assert.assertNotEquals(actualResult, 2);
    }

    @AfterClass
    @Override
    public void afterClass() {
        super.afterClass();
        System.out.println("one more method was override ");
    }
}
