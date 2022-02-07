package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class SampleExternalCalculatorDataProviderTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorExternalDataProvider.class,
          dataProvider = "sumCalculatorDataProvider")
    public void sumCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.sum(a, b);
        assertEquals(actualResult, expectedResult);
    }

    @Test(dataProviderClass = CalculatorExternalDataProvider.class,
          dataProvider = "Subtract test data for calculator")
    public void subtractCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.subtract(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
