package ru.levelp.at.taf.tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.taf.service.driver.WebDriverSingleton;
import ru.levelp.at.taf.steps.ActionSteps;
import ru.levelp.at.taf.steps.AssertionSteps;

@Slf4j
public abstract class SeleniumBaseIT {

    protected WebDriver driver;

    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    @BeforeMethod
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        // Открыли браузер
        var options = new ChromeOptions().setHeadless(headless);
        driver = WebDriverSingleton.getDriver();

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
