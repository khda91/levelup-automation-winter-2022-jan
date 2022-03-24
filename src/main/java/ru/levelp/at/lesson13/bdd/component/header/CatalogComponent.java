package ru.levelp.at.lesson13.bdd.component.header;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson13.bdd.component.AbstractBasePageComponent;

public class CatalogComponent extends AbstractBasePageComponent {

    public CatalogComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Open product category '{0}'")
    public void selectCategory(final String categoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(categoryName))).click();
    }
}
