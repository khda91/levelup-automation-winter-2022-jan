package ru.levelp.at.lesson0507.selenium.basic.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class SampleSeleniumQuitCloseTest {

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
    public void webdriverCloseQuitTest() {
        driver.switchTo().newWindow(WindowType.TAB);
        SleepUtils.sleep(750);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://sbermegamarket.ru/");
        SleepUtils.sleep(750);

        driver.switchTo().newWindow(WindowType.WINDOW);
        SleepUtils.sleep(750);

        driver.close();

        SleepUtils.sleep(1000);

        driver.quit();
    }
}
