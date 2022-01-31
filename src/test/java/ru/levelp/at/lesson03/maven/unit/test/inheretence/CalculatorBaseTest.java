package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson03.maven.unit.test.Calculator;

public abstract class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getCanonicalName() + "#beforeClass");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getCanonicalName() + "#setUp");
        calculator = new Calculator();
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
