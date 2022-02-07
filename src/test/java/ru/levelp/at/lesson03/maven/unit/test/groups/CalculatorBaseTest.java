package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson03.maven.unit.test.Calculator;

public abstract class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getCanonicalName() + "#beforeSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getCanonicalName() + "#beforeClass");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getCanonicalName() + "#setUp");
        calculator = new Calculator();
    }

    @AfterMethod(groups = {"positive", "negative"})
    public void tearDown() {
        calculator = null;
        System.out.println(this.getClass().getCanonicalName() + "#tearDown");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getCanonicalName() + "#afterClass");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getCanonicalName() + "#afterSuite");
    }
}
