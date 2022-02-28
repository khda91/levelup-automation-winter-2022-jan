package ru.levelp.at.lesson0507.selenium.page.object.composite.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardComponent extends AbstractBasePageComponent {

    private static final By PRODUCT_CARD_TITLE_LOCATOR = By.cssSelector("a.ProductCardHorizontal__title");
    private static final By ADD_TO_COMPARE_BUTTON_LOCATOR =
        By.xpath(".//label[contains(@class, 'js--AddToComparison')]");

    private WebElement root;

    public ProductCardComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public String getProductCardTitle() {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, PRODUCT_CARD_TITLE_LOCATOR))
                   .getText();
    }

    public void clickToAddToCompareButton() {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, ADD_TO_COMPARE_BUTTON_LOCATOR))
            .click();
    }
}
