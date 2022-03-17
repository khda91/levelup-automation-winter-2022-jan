package ru.levelp.at.lesson1011.cicd.step.desing.pattern.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson1011.cicd.step.desing.pattern.step.ActionSteps;
import ru.levelp.at.lesson1011.cicd.step.desing.pattern.step.AssertionSteps;

@Slf4j
public abstract class SeleniumBaseTest {

    protected WebDriver driver;

    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        log.info("headless mode -> " + headless);

        // Открыли браузер
        var options = new ChromeOptions().setHeadless(headless);
        driver = new ChromeDriver(options);

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);

        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
