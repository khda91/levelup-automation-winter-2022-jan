package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorPowerTest extends CalculatorBaseTest {

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        System.out.println("this method was override");
    }

    @Test
    public void testCalculatorPower() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPower");
        int actualResult = calculator.power(2, 10);
        Assertions.assertEquals(1024, actualResult);
    }

    @Test
    public void testCalculatorPowerNegativeAssertThrows() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPowerNegativeAssertThrows");
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.power(2, -2));
    }

    @Test
    public void testCalculatorPowerNotEquals() {
        System.out.println(this.getClass().getCanonicalName() + "#testCalculatorPowerNotEquals");
        int actualResult = calculator.power(2, 0);
        Assertions.assertNotEquals(2, actualResult);
    }

    @AfterAll
    @Override
    public void afterClass() {
        super.afterClass();
        System.out.println("one more method was override ");
    }
}
