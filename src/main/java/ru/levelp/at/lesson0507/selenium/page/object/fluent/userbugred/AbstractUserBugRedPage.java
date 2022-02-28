package ru.levelp.at.lesson0507.selenium.page.object.fluent.userbugred;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractUserBugRedPage {

    private static final String BASE_URL = "http://users.bugred.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractUserBugRedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeUrl) {
        driver.navigate().to(BASE_URL + relativeUrl);
    }
}
