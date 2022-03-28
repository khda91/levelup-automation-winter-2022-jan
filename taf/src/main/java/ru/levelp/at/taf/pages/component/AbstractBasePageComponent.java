package ru.levelp.at.taf.pages.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.taf.configuration.CommonConfiguration;

public abstract class AbstractBasePageComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractBasePageComponent(WebDriver driver) {
        this.driver = driver;
        int timeoutDuration = CommonConfiguration.getInstance().explicitlyWaitTimeoutInSeconds();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutDuration));
        PageFactory.initElements(driver, this);
    }
}
