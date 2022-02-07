package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorSumTest extends CalculatorBaseTest {

    @Test
    public void testCalculatorSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSum");
        int actualResult = calculator.sum(2, 2);
        Assertions.assertEquals(4, actualResult);
    }
}
