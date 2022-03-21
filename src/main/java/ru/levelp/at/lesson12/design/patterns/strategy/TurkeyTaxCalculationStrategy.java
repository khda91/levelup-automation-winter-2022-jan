package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TurkeyTaxCalculationStrategy implements TaxCalculationStrategy {

    private static final BigDecimal TAX_RATE_BELOW_8800 = new BigDecimal("0.15");
    private static final BigDecimal TAX_RATE_BETWEEN_8801_22000 = new BigDecimal("0.20");
    private static final BigDecimal TAX_RATE_BETWEEN_22001_50000 = new BigDecimal("0.27");
    private static final BigDecimal TAX_RATE_ABOVE_50001 = new BigDecimal("0.35");

    private static final BigDecimal INCOME_8800 = new BigDecimal("8800");
    private static final BigDecimal INCOME_22000 = new BigDecimal("22000");
    private static final BigDecimal INCOME_50000 = new BigDecimal("50000");

    @Override
    public BigDecimal calculateTax(BigDecimal income) {
        if (income == null) {
            throw new IllegalArgumentException("Income cannot be null");
        }
        if (income.compareTo(INCOME_8800) <= 0) {
            return TAX_RATE_BELOW_8800.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else if (income.compareTo(INCOME_8800) > 0 && income.compareTo(INCOME_22000) <= 0) {
            return TAX_RATE_BETWEEN_8801_22000.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else if (income.compareTo(INCOME_22000) > 0 && income.compareTo(INCOME_50000) <= 0) {
            return TAX_RATE_BETWEEN_22001_50000.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else {
            return TAX_RATE_ABOVE_50001.multiply(income).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
