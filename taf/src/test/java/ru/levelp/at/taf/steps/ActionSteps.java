package ru.levelp.at.taf.steps;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.pages.CitilinkCatalogCategoryPage;
import ru.levelp.at.taf.pages.CitilinkIndexPage;
import ru.levelp.at.taf.pages.CitilinkProductListPage;

public class ActionSteps {

    private WebDriver driver;

    private CitilinkIndexPage indexPage;
    private CitilinkCatalogCategoryPage catalogCategoryPage;
    private CitilinkProductListPage productCardListPage;

    public ActionSteps(WebDriver driver) {
        this.driver = driver;
        indexPage = new CitilinkIndexPage(driver);
        catalogCategoryPage = new CitilinkCatalogCategoryPage(driver);
        productCardListPage = new CitilinkProductListPage(driver);
    }

    @Step("Открыть главную страницу Citilink")
    public void openCitilinkIndexPage() {
        indexPage.open();
    }

    @Step("Открыть подкатегорию '{subcategory}' в каталоге категории '{category}'")
    public void openSubcategoryInCatalogCategory(final String category, final String subcategory) {
        indexPage.header().clickToCatalogButton();
        indexPage.header().catalog().selectCategory(category);
        catalogCategoryPage.selectSubcategory(subcategory);
    }

    @Step("Добавить к сравнению товары с индексами {productIndexes}")
    public List<String> addProductsToCompareList(List<Integer> productIndexes) {
        List<String> expectedAddedProductTitlesToCompare = new ArrayList<>();

        for (Integer productIndex : productIndexes) {
            productCardListPage.productCard(productIndex).clickToAddToCompareButton();
            String productCardTitle = productCardListPage.productCard(productIndex).getProductCardTitle();
            expectedAddedProductTitlesToCompare.add(productCardTitle);
        }

        productCardListPage.header().clickToCompareButton();

        return expectedAddedProductTitlesToCompare;
    }
}
