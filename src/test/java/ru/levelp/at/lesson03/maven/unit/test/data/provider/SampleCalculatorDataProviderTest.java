package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class SampleCalculatorDataProviderTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] sumCalculatorDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 4, 7},
            {8, 16, 24}
        };
    }

    @Test(dataProvider = "sumCalculatorDataProvider")
    public void sumCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.sum(a, b);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "Subtract test data for calculator")
    public Object[][] subtractCalculatorDataProvider() {
        return new Object[][] {
            {2, 2, 0},
            {3, 4, -1},
            {8, 16, -8},
            {9, 8, 1}
        };
    }

    @Test(dataProvider = "Subtract test data for calculator")
    public void subtractCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.subtract(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
