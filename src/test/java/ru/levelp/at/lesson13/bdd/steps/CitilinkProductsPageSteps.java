package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.CitilinkProductListPage;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class CitilinkProductsPageSteps {

    @ParameterType(value = "(.*)")
    public List<Integer> productIndexes(String indexes) {
        return Arrays.stream(indexes.split(","))
                     .map(index -> Integer.parseInt(index.trim()))
                     .collect(Collectors.toList());
    }

    @When("I add products with indexes '{productIndexes}' to Compare list on Citilink Products page")
    public void addProductsWithIndexesToCompareListOnCitilinkProductsPage(List<Integer> productIndexes) {
        WebDriver driver = (WebDriver) TestContext.getInstance().getObject("webdriver");
        var productCardListPage = new CitilinkProductListPage(driver);
        List<String> expectedAddedProductTitlesToCompare = new ArrayList<>();

        for (Integer productIndex : productIndexes) {
            productCardListPage.productCard(productIndex).clickToAddToCompareButton();
            String productCardTitle = productCardListPage.productCard(productIndex).getProductCardTitle();
            expectedAddedProductTitlesToCompare.add(productCardTitle);
        }

        productCardListPage.header().clickToCompareButton();

        TestContext.getInstance().addObject("added_product_names", expectedAddedProductTitlesToCompare);
    }
}
