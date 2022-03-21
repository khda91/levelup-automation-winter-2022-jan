package ru.levelp.at.lesson12.design.patterns.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxCalculationStrategyTest {

    @DataProvider
    public Object[][] taxDataProvider() {
        return new Object[][] {
            {"russian tax", new RussiaTaxCalculationStrategy(), new BigDecimal("1000"), new BigDecimal("130.00")},
            {"turkey tax", new TurkeyTaxCalculationStrategy(), new BigDecimal("7000"), new BigDecimal("1050.00")},
            {"turkey tax", new TurkeyTaxCalculationStrategy(), new BigDecimal("15000"), new BigDecimal("3000.00")},
            {"turkey tax", new TurkeyTaxCalculationStrategy(), new BigDecimal("43500"), new BigDecimal("11745.00")},
            {"turkey tax", new TurkeyTaxCalculationStrategy(), new BigDecimal("60000"), new BigDecimal("21000.00")}
        };
    }

    @Test(dataProvider = "taxDataProvider")
    public void taxCalculatorTest(String name, TaxCalculationStrategy strategy,
                                  BigDecimal income, BigDecimal expectedTax) {
        System.out.println(String.format("Calculate %s for income %s", name, income));
        var taxProvider = new TaxCalculationProviderImpl(strategy);
        BigDecimal actualTax = taxProvider.calculateTax(income);

        assertThat(actualTax).isEqualTo(expectedTax);
    }
}
