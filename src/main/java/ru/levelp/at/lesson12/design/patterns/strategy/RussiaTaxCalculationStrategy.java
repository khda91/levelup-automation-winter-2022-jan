package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RussiaTaxCalculationStrategy implements TaxCalculationStrategy {

    private static final BigDecimal TAX_RATE = new BigDecimal("0.13");

    @Override
    public BigDecimal calculateTax(BigDecimal income) {
        if (income == null) {
            throw new IllegalArgumentException("Income cannot be null");
        }
        return TAX_RATE.multiply(income).setScale(2, RoundingMode.HALF_UP);
    }
}
