package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.maven.unit.test.groups.tags.Positive;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class CalculatorSumSoftAssertionTest extends CalculatorBaseTest {

    @Test
    @Positive
    public void testCalculatorHardAssertSum() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorHardAssertSum");
        int actualResult1 = calculator.sum(2, 2);
        int actualResult2 = calculator.sum(actualResult1, 2);
        int actualResult3 = calculator.sum(actualResult2, 3);
        int actualResult4 = calculator.sum(actualResult3, 4);

        Assertions.assertEquals(actualResult1, 4);
        Assertions.assertEquals(actualResult2, 6);
        Assertions.assertEquals(actualResult3, 9);
        Assertions.assertEquals(actualResult4, 13);
    }
}
