package ru.levelp.at.lesson0507.selenium.page.object.sample;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitilinkIndexPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".MainHeader__search [name='text']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[contains(@class, 'MainHeader__search')]"
        + "//button[contains(@class, 'InputSearch__button_search')]")
    private WebElement searchButton;

    public CitilinkIndexPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public CitilinkIndexPage(WebDriver driver, long timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void open() {
        driver.navigate().to("https://www.citilink.ru/");
    }

    public void sendKeysToSearchTextBox(final String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchTextBox)).sendKeys(searchText);
    }

    public void clickToSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
