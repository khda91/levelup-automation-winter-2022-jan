package ru.levelp.at.lesson0507.selenium.page.object.fluent;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.object.SeleniumPageObjectBaseTest;
import ru.levelp.at.lesson0507.selenium.page.object.fluent.CitilinkIndexPage;

public class SeleniumCitilinkSearchPageObjectTest extends SeleniumPageObjectBaseTest {

    @Test
    public void searchTest() {

        var actualProductTitles = new CitilinkIndexPage(driver)
            .open()
            .sendKeysToSearchTextBox("мышка")
            .clickToSearchButton()
            .getProductTitles();

        SoftAssertions softAssertions = new SoftAssertions();
        actualProductTitles.forEach(actualProductTitle -> softAssertions
            .assertThat(actualProductTitle)
            .as("Product title does not contain search criteria")
            .containsIgnoringCase("мыш"));

        softAssertions.assertAll();
    }
}
