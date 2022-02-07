package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test
    public void testCalculatorSubtract() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSubtract");
        int actualResult = calculator.subtract(2, 2);
        Assertions.assertEquals(0, actualResult);
    }

}
