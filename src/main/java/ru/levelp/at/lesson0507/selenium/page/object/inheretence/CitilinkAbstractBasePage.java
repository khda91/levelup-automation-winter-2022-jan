package ru.levelp.at.lesson0507.selenium.page.object.inheretence;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CitilinkAbstractBasePage {

    private static final String SITE_URL = "https://www.citilink.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = ".MainHeader__search [name='text']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[contains(@class, 'MainHeader__search')]"
        + "//button[contains(@class, 'InputSearch__button_search')]")
    private WebElement searchButton;

    protected CitilinkAbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativePageUrl) {
        driver.navigate().to(SITE_URL + relativePageUrl);
    }

    public void sendKeysToSearchTextBox(final String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchTextBox)).sendKeys(searchText);
    }

    public void clickToSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
