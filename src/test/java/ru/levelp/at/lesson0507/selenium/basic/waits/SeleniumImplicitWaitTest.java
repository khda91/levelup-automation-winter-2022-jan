package ru.levelp.at.lesson0507.selenium.basic.waits;

import java.time.Duration;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.basic.SeleniumBaseTest;

public class SeleniumImplicitWaitTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        // Selenium v3
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Selenium v4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void searchTest() {
        long startTime = System.currentTimeMillis();
        try {
            var searchTextBox = driver.findElement(By.cssSelector(".MainHeader__search [name='text']"));
            searchTextBox.sendKeys("мышка");

            driver.findElement(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]")).click();

            var foundProducts = driver.findElements(By.className("ProductCardVertical__name"));
            var foundProductTitles = foundProducts
                .stream()
                .map(foundProduct -> {
                    try {
                        return foundProduct.getText();
                    } catch (StaleElementReferenceException e) {
                        return foundProduct.getText();
                    }
                })
                .collect(Collectors.toList());

            SoftAssertions softAssertions = new SoftAssertions();
            foundProductTitles.forEach(foundProductTitle -> softAssertions
                .assertThat(foundProductTitle)
                .as("Product title does not contain search criteria")
                .containsIgnoringCase("мыш"));
            softAssertions.assertAll();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Test %s#%s execution time is %d ms", this.getClass().getSimpleName(),
                "searchTest", (endTime - startTime)));
        }
    }
}
