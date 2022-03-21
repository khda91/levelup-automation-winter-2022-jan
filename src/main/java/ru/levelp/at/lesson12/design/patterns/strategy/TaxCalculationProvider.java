package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;

public interface TaxCalculationProvider {

    BigDecimal calculateTax(final BigDecimal income);
}
