package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;

public class TaxCalculationProviderImpl implements TaxCalculationProvider {

    private final TaxCalculationStrategy taxCalculation;

    public TaxCalculationProviderImpl(TaxCalculationStrategy taxCalculation) {
        this.taxCalculation = taxCalculation;
    }

    @Override
    public BigDecimal calculateTax(BigDecimal income) {
        return taxCalculation.calculateTax(income);
    }
}
