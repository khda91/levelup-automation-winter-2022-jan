package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class SampleExternalCalculatorDataProviderTest extends CalculatorBaseTest {

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson03.maven.unit.test.data.provider.CalculatorExternalDataProvider"
        + "#sumCalculatorDataProvider")
    public void sumCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.sum(a, b);
        assertEquals(actualResult, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson03.maven.unit.test.data.provider.CalculatorExternalDataProvider"
        + "#subtractCalculatorDataProvider")
    public void subtractCalculatorTest(int a, int b, int expectedResult) {
        int actualResult = calculator.subtract(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
