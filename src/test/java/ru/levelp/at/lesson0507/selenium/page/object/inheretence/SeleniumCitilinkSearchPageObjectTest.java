package ru.levelp.at.lesson0507.selenium.page.object.inheretence;

import org.assertj.core.api.SoftAssertions;
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
}
