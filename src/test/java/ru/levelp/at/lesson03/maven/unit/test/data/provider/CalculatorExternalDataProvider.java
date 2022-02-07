package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class CalculatorExternalDataProvider {

    public static Stream<Arguments> sumCalculatorDataProvider() {
        return Stream.of(
            Arguments.arguments(2, 3, 5),
            Arguments.arguments(3, 5, 8),
            Arguments.arguments(8, 17, 25)
        );
    }

    public static Stream<Arguments> subtractCalculatorDataProvider() {
        return Stream.of(
            Arguments.arguments(2, 3, -1),
            Arguments.arguments(3, 5, -2),
            Arguments.arguments(8, 15, -7),
            Arguments.arguments(9, 9, 0)
        );
    }
}
