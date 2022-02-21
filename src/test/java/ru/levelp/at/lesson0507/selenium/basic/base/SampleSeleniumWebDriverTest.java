package ru.levelp.at.lesson0507.selenium.basic.base;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleSeleniumWebDriverTest {

    @Test
    public void sampleSeleniumTest() {
        // Указываем путь до самого драйвера
        System.setProperty("webdriver.chrome.driver",
            this.getClass().getResource("/ru/levelp/at/lesson05/lesson07/selenium/basic/drivers/chromedriver")
                .getPath());

        // Открыли браузер
        WebDriver driver = new ChromeDriver();

        // открываем сайт
        driver.navigate().to("https://www.citilink.ru/");

        // забираем название сайта
        var actualTitle = driver.getTitle();

        // проверяем название
        assertThat(actualTitle)
            .isEqualTo("Бытовая техника и электроника в интернет-магазине Ситилинк - Санкт-Петербург");

        // закрываем браузер
        driver.quit();
    }
}
