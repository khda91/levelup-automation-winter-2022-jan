package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import org.testng.annotations.DataProvider;

public class CalculatorExternalDataProvider {

    @DataProvider
    public static Object[][] sumCalculatorDataProvider() {
        return new Object[][] {
            {2, 3, 5},
            {3, 5, 8},
            {8, 17, 25}
        };
    }

    @DataProvider(name = "Subtract test data for calculator")
    public static Object[][] subtractCalculatorDataProvider() {
        return new Object[][] {
            {2, 3, -1},
            {3, 5, -2},
            {8, 15, -7},
            {9, 9, 0}
        };
    }
}
