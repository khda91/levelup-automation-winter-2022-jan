package ru.levelp.at.lesson13.bdd.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class CucumberHooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        TestContext.getInstance().addObject("webdriver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanUp();
    }
}
