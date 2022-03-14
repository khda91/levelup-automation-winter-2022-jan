package ru.levelp.at.lesson1011.cicd;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CitilinkCatalogCategoryPage extends CitilinkAbstractBasePage {

    public CitilinkCatalogCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open product subcategory '{subcategoryName}'")
    public void selectSubcategory(final String subcategoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(subcategoryName))).click();
    }
}
