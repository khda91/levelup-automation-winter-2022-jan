package ru.levelp.at.lesson03.maven.unit.test.inheretence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson03.maven.unit.test.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class CalculatorBaseTest {

    protected Calculator calculator;

    @BeforeAll
    public void beforeClass() {
        System.out.println(this.getClass().getCanonicalName() + "#beforeClass");
    }

    @BeforeEach
    public void setUp() {
        System.out.println(this.getClass().getCanonicalName() + "#setUp");
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println(this.getClass().getCanonicalName() + "#tearDown");
    }

    @AfterAll
    public void afterClass() {
        System.out.println(this.getClass().getCanonicalName() + "#afterClass");
    }

}
