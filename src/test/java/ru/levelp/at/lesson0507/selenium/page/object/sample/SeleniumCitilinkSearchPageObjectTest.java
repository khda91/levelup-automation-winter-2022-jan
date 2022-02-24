package ru.levelp.at.lesson0507.selenium.page.object.sample;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.object.SeleniumPageObjectBaseTest;

public class SeleniumCitilinkSearchPageObjectTest extends SeleniumPageObjectBaseTest {

    @Test
    public void searchTest() {
        CitilinkIndexPage indexPage = new CitilinkIndexPage(driver);

        indexPage.open();

        indexPage.sendKeysToSearchTextBox("мышка");
        indexPage.clickToSearchButton();

        CitilinkSearchResultPage searchResultPage = new CitilinkSearchResultPage(driver);
        var actualProductTitles = searchResultPage.getProductTitles();

        SoftAssertions softAssertions = new SoftAssertions();
        actualProductTitles.forEach(actualProductTitle -> softAssertions
            .assertThat(actualProductTitle)
            .as("Product title does not contain search criteria")
            .containsIgnoringCase("мыш"));

        softAssertions.assertAll();
    }

    @Test
    public void searchPageFactoryInTestTest() {
        CitilinkIndexPage indexPage = PageFactory.initElements(driver, CitilinkIndexPage.class);
        CitilinkSearchResultPage searchResultPage = PageFactory.initElements(driver, CitilinkSearchResultPage.class);

        indexPage.open();

        indexPage.sendKeysToSearchTextBox("мышка");
        indexPage.clickToSearchButton();

        var actualProductTitles = searchResultPage.getProductTitles();

        SoftAssertions softAssertions = new SoftAssertions();
        actualProductTitles.forEach(actualProductTitle -> softAssertions
            .assertThat(actualProductTitle)
            .as("Product title does not contain search criteria")
            .containsIgnoringCase("мыш"));

        softAssertions.assertAll();
    }

    @Test
    public void searchWithoutPageFactoryTest() {
        CitilinkIndexPage indexPage = new CitilinkIndexPage(driver, 5);
        CitilinkSearchResultPage searchResultPage = new CitilinkSearchResultPage(driver, 5);

        indexPage.open();

        indexPage.sendKeysToSearchTextBox("мышка");
        indexPage.clickToSearchButton();

        var actualProductTitles = searchResultPage.getProductTitles();

        SoftAssertions softAssertions = new SoftAssertions();
        actualProductTitles.forEach(actualProductTitle -> softAssertions
            .assertThat(actualProductTitle)
            .as("Product title does not contain search criteria")
            .containsIgnoringCase("мыш"));

        softAssertions.assertAll();
    }
}
