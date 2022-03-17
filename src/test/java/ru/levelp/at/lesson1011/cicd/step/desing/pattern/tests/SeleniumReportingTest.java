package ru.levelp.at.lesson1011.cicd.step.desing.pattern.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
        actionSteps.openCitilinkIndexPage();

        actionSteps.openSubcategoryInCatalogCategory("Смартфоны и гаджеты", "Смартфоны");

        List<String> expectedAddedProductTitlesToCompare = actionSteps.addProductsToCompareList(List.of(0, 1));

        assertionSteps.assertThatSelectedProductsAddedToCompareList(expectedAddedProductTitlesToCompare);
    }

    @Test(description = "Add products to Compare List another test")
    @Description("Проверяем функциональность добавления товаров в список для сравнения их характеристик")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Сравнение товаров")
    @Feature("Проверка добавления к списку для сравнения продуктов")
    public void addToCompareAnotherTest() {
        actionSteps.openCitilinkIndexPage();

        actionSteps.openSubcategoryInCatalogCategory("Смартфоны и гаджеты", "Смартфоны");

        List<String> expectedAddedProductTitlesToCompare = actionSteps.addProductsToCompareList(List.of(0, 1));
        expectedAddedProductTitlesToCompare.add("sajhckjas");

        assertionSteps.assertThatSelectedProductsAddedToCompareList(expectedAddedProductTitlesToCompare);
    }
}
