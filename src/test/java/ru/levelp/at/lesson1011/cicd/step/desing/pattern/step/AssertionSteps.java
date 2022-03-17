package ru.levelp.at.lesson1011.cicd.step.desing.pattern.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.cicd.CitilinkComparePage;

public class AssertionSteps {

    private WebDriver driver;
    private CitilinkComparePage comparePage;

    public AssertionSteps(WebDriver driver) {
        this.driver = driver;
        comparePage = new CitilinkComparePage(driver);
    }

    @Step("Провека, что выбранные товары '{expectedProductTitles}' были добавлены в список для сравнения")
    public void assertThatSelectedProductsAddedToCompareList(final List<String> expectedProductTitles) {
        var comparePage = new CitilinkComparePage(driver);
        var actualAddedProductTitlesToCompare = comparePage.getComparedProductTitles();

        assertThat(actualAddedProductTitlesToCompare)
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
