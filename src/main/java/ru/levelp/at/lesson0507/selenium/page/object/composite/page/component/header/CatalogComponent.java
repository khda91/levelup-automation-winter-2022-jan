package ru.levelp.at.lesson0507.selenium.page.object.composite.page.component.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson0507.selenium.page.object.composite.page.component.AbstractBasePageComponent;

public class CatalogComponent extends AbstractBasePageComponent {

    public CatalogComponent(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(final String categoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(categoryName))).click();
    }
}
