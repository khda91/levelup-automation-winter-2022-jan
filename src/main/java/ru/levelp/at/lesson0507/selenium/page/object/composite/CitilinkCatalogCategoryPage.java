package ru.levelp.at.lesson0507.selenium.page.object.composite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CitilinkCatalogCategoryPage extends CitilinkAbstractBasePage {

    public CitilinkCatalogCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubcategory(final String subcategoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(subcategoryName))).click();
    }
}
