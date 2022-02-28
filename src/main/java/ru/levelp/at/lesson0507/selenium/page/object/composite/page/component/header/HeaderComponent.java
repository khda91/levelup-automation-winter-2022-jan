package ru.levelp.at.lesson0507.selenium.page.object.composite.page.component.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson0507.selenium.page.object.composite.page.component.AbstractBasePageComponent;

public class HeaderComponent extends AbstractBasePageComponent {

    @FindBy(css = ".PopupCatalogMenu__button-open")
    private WebElement catalogButton;

    @FindBy(css = ".MainHeader__search [name='text']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[contains(@class, 'MainHeader__search')]"
        + "//button[contains(@class, 'InputSearch__button_search')]")
    private WebElement searchButton;

    @FindBy(css = "[data-name='compare']")
    private WebElement compareButton;

    private CatalogComponent catalog;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        catalog = new CatalogComponent(driver);
    }

    public void clickToCatalogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogButton)).click();
    }

    public CatalogComponent catalog() {
        return catalog;
    }

    public void sendKeysToSearchTextBox(final String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchTextBox)).sendKeys(searchText);
    }

    public void clickToSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void clickToCompareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }
}
