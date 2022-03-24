package ru.levelp.at.lesson13.bdd;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CitilinkComparePage extends CitilinkAbstractBasePage {

    private static final By COMPARED_PRODUCT_TITLE_LIST_LOCATOR =
        By.xpath("//div[contains(@class, 'Compare__product-name-render')]"
            + "//div[contains(@class, 'Compare__product-cell')]/a");

    public CitilinkComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getComparedProductTitles() {
        return wait.until(ExpectedConditions
                       .numberOfElementsToBeMoreThan(COMPARED_PRODUCT_TITLE_LIST_LOCATOR, 1))
                   .stream()
                   .map(WebElement::getText)
                   .collect(Collectors.toList());
    }
}
