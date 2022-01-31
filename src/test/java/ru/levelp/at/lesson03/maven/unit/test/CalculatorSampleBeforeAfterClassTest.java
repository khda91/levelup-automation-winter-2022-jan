package ru.levelp.at.lesson03.maven.unit.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorSampleBeforeAfterClassTest {

    private Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getCanonicalName() + "#beforeClass");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getCanonicalName() + "#setUp");
        calculator = new Calculator();
    }

    @Test
    public void testCalculatorSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSum");
        int actualResult = calculator.sum(2, 2);
        Assert.assertEquals(actualResult, 4);
    }

    @Test
    public void testCalculatorSubtract() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSubtract");
        int actualResult = calculator.subtract(2, 2);
        Assert.assertEquals(actualResult, 0);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
        System.out.println(this.getClass().getCanonicalName() + "#tearDown");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getCanonicalName() + "#afterClass");
    }

}
