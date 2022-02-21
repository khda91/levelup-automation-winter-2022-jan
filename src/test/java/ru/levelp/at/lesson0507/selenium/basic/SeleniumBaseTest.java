package ru.levelp.at.lesson0507.selenium.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {

        // Открыли браузер
        driver = new ChromeDriver();

        // открываем сайт
        driver.navigate().to("https://www.citilink.ru/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
