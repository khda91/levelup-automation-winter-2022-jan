package ru.levelp.at.taf.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.taf.configuration.CommonConfiguration;
import ru.levelp.at.taf.pages.component.header.HeaderComponent;

public abstract class CitilinkAbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final String siteUrl;

    private HeaderComponent header;

    protected CitilinkAbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.siteUrl = CommonConfiguration.getInstance().siteUrl();
        int timeoutDuration = CommonConfiguration.getInstance().explicitlyWaitTimeoutInSeconds();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutDuration));
        PageFactory.initElements(driver, this);
        header = new HeaderComponent(driver);
    }

    protected void open(final String relativePageUrl) {
        driver.navigate().to(siteUrl + relativePageUrl);
    }

    public HeaderComponent header() {
        return header;
    }
}
