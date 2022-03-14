package ru.levelp.at.lesson1011.cicd;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelp.at.lesson1011.cicd.listener.AllureListener;

@Epic("Add product to compare")
@Listeners({AllureListener.class})
public class SeleniumReportingTest extends SeleniumBaseTest {

    @Test(description = "Add products to Compare List test")
    @Description("Проверяем функциональность добавления товаров в список для сравнения их характеристик")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Comparing")
    @Feature("Check adding to comparing list")
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

    @Test(description = "Add products to Compare List another test")
    @Description("Проверяем функциональность добавления товаров в список для сравнения их характеристик")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Сравнение товаров")
    @Feature("Проверка добавления к списку для сравнения продуктов")
    public void addToCompareAnotherTest() {
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

        expectedAddedProductTitlesToCompare.add("sajhckjas");

        assertThat(actualAddedProductTitlesToCompare)
            .containsExactlyInAnyOrderElementsOf(expectedAddedProductTitlesToCompare);
    }
}
