package ru.levelp.at.lesson13.bdd;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson13.bdd.component.header.HeaderComponent;

public abstract class CitilinkAbstractBasePage {

    private static final String SITE_URL = "https://www.citilink.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    private HeaderComponent header;

    protected CitilinkAbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        header = new HeaderComponent(driver);
    }

    protected void open(final String relativePageUrl) {
        driver.navigate().to(SITE_URL + relativePageUrl);
    }

    public HeaderComponent header() {
        return header;
    }
}
