package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.test.groups.tags.Positive;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test
    @Positive
    public void testCalculatorSubtract() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSubtract");
        int actualResult = calculator.subtract(2, 2);
        Assertions.assertEquals(0, actualResult);
    }

}
