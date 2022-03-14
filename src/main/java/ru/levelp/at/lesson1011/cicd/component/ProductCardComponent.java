package ru.levelp.at.lesson1011.cicd.component;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCardComponent extends AbstractBasePageComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCardComponent.class);

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

    @Step("Добавить к сравнению выбраный продукт")
    public void clickToAddToCompareButton() {
        LOGGER.info("click to 'Add to compare' button on product card");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, ADD_TO_COMPARE_BUTTON_LOCATOR))
            .click();
    }
}
