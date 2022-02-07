package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.test.groups.tags.Positive;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class CalculatorSumTest extends CalculatorBaseTest {

    @Test
    @Positive
    public void testCalculatorSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorSum");
        int actualResult = calculator.sum(2, 2);
        Assertions.assertEquals(4, actualResult);
    }
}
