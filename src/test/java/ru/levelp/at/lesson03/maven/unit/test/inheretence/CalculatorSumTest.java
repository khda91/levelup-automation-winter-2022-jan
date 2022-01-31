package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.test.Calculator;

public class CalculatorSumTest extends CalculatorBaseTest {

    @Test
    public void testCalculatorSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSum");
        int actualResult = calculator.sum(2, 2);
        Assert.assertEquals(actualResult, 4);
    }

}
