package ru.levelp.at.lesson13.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.cicd.CitilinkComparePage;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class CompareProductPageSteps {

    // WHEN

    // THEN

    @Then("added products should be displayed on Citilink Compare Products page")
    public void addedProductsShouldBeDisplayedOnCitilinkCompareProductsPage() {
        WebDriver driver = (WebDriver) TestContext.getInstance().getObject("webdriver");
        var comparePage = new CitilinkComparePage(driver);
        var actualAddedProductTitlesToCompare = comparePage.getComparedProductTitles();

        List<String> expectedProductTitles = (List<String>) TestContext.getInstance()
                                                                       .getObject("added_product_names");
        assertThat(actualAddedProductTitlesToCompare)
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
