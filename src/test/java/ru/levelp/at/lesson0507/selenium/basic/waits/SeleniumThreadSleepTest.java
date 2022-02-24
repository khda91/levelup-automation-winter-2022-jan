package ru.levelp.at.lesson0507.selenium.basic.waits;

import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.basic.SeleniumBaseTest;

public class SeleniumThreadSleepTest extends SeleniumBaseTest {

    @Test
    public void searchTest() {
        long startTime = System.currentTimeMillis();
        try {
            sleep(2000);
            var searchTextBox = driver.findElement(By.cssSelector(".MainHeader__search [name='text']"));
            searchTextBox.sendKeys("мышка");

            driver.findElement(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]")).click();

            sleep(3500);

            var foundProducts = driver.findElements(By.className("ProductCardVertical__name"));
            var foundProductTitles = foundProducts
                .stream()
                .map(WebElement::getText)
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

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
