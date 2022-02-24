package ru.levelp.at.lesson0507.selenium.basic.waits;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.basic.SeleniumBaseTest;

public class SeleniumExplicitVsImplicitWaitTest extends SeleniumBaseTest {

    private WebDriverWait wait;

    @Test
    public void searchImplicitEqualsExplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        long startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".MainHeader__search [name='text']")));
            searchTextBox.sendKeys("мышка");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]"))).click();

            List<WebElement> foundProducts = null;
            long startTimeFindBy = System.currentTimeMillis();
            try {
                foundProducts = wait.until(ExpectedConditions
                    .numberOfElementsToBeMoreThan(By.className("ProductCardVertical__name1"), 3));
            } finally {
                long endTimeFindBy = System.currentTimeMillis();
                System.out.println(String.format("Element was not found in %d ms", (endTimeFindBy - startTimeFindBy)));
            }

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
                "searchImplicitEqualsExplicitWaitTest", (endTime - startTime)));
        }
    }

    @Test
    public void searchImplicitLessExplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        long startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".MainHeader__search [name='text']")));
            searchTextBox.sendKeys("мышка");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]"))).click();

            List<WebElement> foundProducts = null;
            long startTimeFindBy = System.currentTimeMillis();
            try {
                foundProducts = wait.until(ExpectedConditions
                    .numberOfElementsToBeMoreThan(By.className("ProductCardVertical__name1"), 3));
            } finally {
                long endTimeFindBy = System.currentTimeMillis();
                System.out.println(String.format("Element was not found in %d ms", (endTimeFindBy - startTimeFindBy)));
            }

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
                "searchImplicitLessExplicitWaitTest", (endTime - startTime)));
        }
    }

    @Test
    public void searchImplicitLessExplicitPlusOneWaitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(11));

        long startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".MainHeader__search [name='text']")));
            searchTextBox.sendKeys("мышка");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]"))).click();

            List<WebElement> foundProducts = null;
            long startTimeFindBy = System.currentTimeMillis();
            try {
                foundProducts = wait.until(ExpectedConditions
                    .numberOfElementsToBeMoreThan(By.className("ProductCardVertical__name1"), 3));
            } finally {
                long endTimeFindBy = System.currentTimeMillis();
                System.out.println(String.format("Element was not found in %d ms", (endTimeFindBy - startTimeFindBy)));
            }

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
                "searchImplicitLessExplicitPlusOneWaitTest", (endTime - startTime)));
        }
    }

    @Test
    public void searchImplicitAndExplicitWaitTogetherTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(11));

        long startTime = System.currentTimeMillis();
        try {
            var searchTextBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".MainHeader__search [name='text']")));
            searchTextBox.sendKeys("мышка");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'MainHeader__search')]"
                + "//button[contains(@class, 'InputSearch__button_search')]"))).click();

            List<WebElement> foundProducts = null;
            var currentImplicitWait = driver.manage().timeouts().getImplicitWaitTimeout();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            long startTimeFindBy = System.currentTimeMillis();
            try {
                foundProducts = wait.until(ExpectedConditions
                    .numberOfElementsToBeMoreThan(By.className("ProductCardVertical__name1"), 3));
            } finally {
                long endTimeFindBy = System.currentTimeMillis();
                System.out.println(String.format("Element was not found in %d ms", (endTimeFindBy - startTimeFindBy)));
                driver.manage().timeouts().implicitlyWait(currentImplicitWait);
            }

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
                "searchImplicitLessExplicitPlusOneWaitTest", (endTime - startTime)));
        }
    }
}
