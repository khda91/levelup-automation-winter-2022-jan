package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.CitilinkCatalogCategoryPage;
import ru.levelp.at.lesson13.bdd.CitilinkIndexPage;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class CitilinkCommonSteps {

    @Given("I open Citilink web site")
    public void openCitilinkWebSite() {
        WebDriver driver = (WebDriver) TestContext.getInstance().getObject("webdriver");
        new CitilinkIndexPage(driver).open();
    }

    @Given("I select {string} subcategory in catalog {string} category")
    public void selectSubcategoryInCatalogCategory(String subcategory, String category) {
        WebDriver driver = (WebDriver) TestContext.getInstance().getObject("webdriver");
        var indexPage = new CitilinkIndexPage(driver);
        var catalogCategoryPage = new CitilinkCatalogCategoryPage(driver);

        indexPage.header().clickToCatalogButton();
        indexPage.header().catalog().selectCategory(category);
        catalogCategoryPage.selectSubcategory(subcategory);
    }

}
