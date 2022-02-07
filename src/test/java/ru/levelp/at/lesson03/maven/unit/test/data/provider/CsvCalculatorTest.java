package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class CsvCalculatorTest extends CalculatorBaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/ru/levelp/at/lesson03_04/unit/tests/data/sample_data.csv", delimiterString = ",")
    public void sumCalculatorTest(Integer a, Integer b, Integer expectedResult) {
        int actualResult = calculator.sum(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
