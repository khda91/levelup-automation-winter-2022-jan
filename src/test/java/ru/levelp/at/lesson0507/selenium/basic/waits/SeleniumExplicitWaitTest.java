package ru.levelp.at.lesson0507.selenium.basic.waits;

import java.time.Duration;
import java.util.ArrayList;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.basic.SeleniumBaseTest;

public class SeleniumExplicitWaitTest extends SeleniumBaseTest {

    private WebDriverWait wait;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();

        // Seleium v3
        // wait = new WebDriverWait(driver, 5);
        // Selenium v4
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void searchTest() {
        long startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".MainHeader__search [name='text']")));
            searchTextBox.sendKeys("мышка");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]"))).click();

            var foundProducts = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.className("ProductCardVertical__name"), 3));
            var foundProductTitles = new ArrayList<String>();

            for (int i = 0; i < foundProducts.size(); i++) {
                String title = "";
                try {
                    title = foundProducts.get(i).getText();
                } catch (StaleElementReferenceException e) {
                    foundProducts = wait.until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.className("ProductCardVertical__name"), 3));
                    title = foundProducts.get(i).getText();
                }
                foundProductTitles.add(title);
            }

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
