package ru.levelp.at.lesson0507.selenium.page.object.composite;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.object.CitilinkComparePage;
import ru.levelp.at.lesson0507.selenium.page.object.SeleniumPageObjectBaseTest;

public class SeleniumCompositElementTest extends SeleniumPageObjectBaseTest {

    @Test
    public void addToCompareTest() {
        var indexPage = new CitilinkIndexPage(driver);
        indexPage.open();

        indexPage.header().clickToCatalogButton();
        indexPage.header().catalog().selectCategory("Смартфоны и гаджеты");

        var catalogCategoryPage = new CitilinkCatalogCategoryPage(driver);
        catalogCategoryPage.selectSubcategory("Смартфоны");

        var productCardListPage = new CitilinkProductListPage(driver);

        List<String> expectedAddedProductTitlesToCompare = new ArrayList<>();

        productCardListPage.productCard(0).clickToAddToCompareButton();
        String productCardTitle = productCardListPage.productCard(0).getProductCardTitle();
        expectedAddedProductTitlesToCompare.add(productCardTitle);

        productCardListPage.productCard(1).clickToAddToCompareButton();
        productCardTitle = productCardListPage.productCard(1).getProductCardTitle();
        expectedAddedProductTitlesToCompare.add(productCardTitle);

        productCardListPage.header().clickToCompareButton();

        var comparePage = new CitilinkComparePage(driver);
        var actualAddedProductTitlesToCompare = comparePage.getComparedProductTitles();

        assertThat(actualAddedProductTitlesToCompare)
            .containsExactlyInAnyOrderElementsOf(expectedAddedProductTitlesToCompare);
    }
}
