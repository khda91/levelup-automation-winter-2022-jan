package ru.levelp.at.lesson0507.selenium.basic.base;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleSeleniumWebDriverManagerTest {

    private WebDriver driver;

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

    @Test
    public void sampleSeleniumTest() {

        // забираем название сайта
        var actualTitle = driver.getTitle();

        // проверяем название
        assertThat(actualTitle)
            .isEqualTo("Бытовая техника и электроника в интернет-магазине Ситилинк - Санкт-Петербург");
    }

    @AfterMethod
    public void tearDown() {
        // закрываем браузер
        driver.quit();
    }
}
