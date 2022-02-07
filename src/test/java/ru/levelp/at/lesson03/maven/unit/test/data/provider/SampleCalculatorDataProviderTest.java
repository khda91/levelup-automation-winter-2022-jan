package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class SampleCalculatorDataProviderTest extends CalculatorBaseTest {

    @ParameterizedTest
    @CsvSource(value = {"2, 2, 4",
        "3, 4, 7",
        "8, 16, 24"})
    public void sumCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.sum(a, b);
        assertEquals(actualResult, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 0",
        "3, 4, -1",
        "8, 16, -8",
        "9, 8, 1"})
    public void subtractCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.subtract(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
