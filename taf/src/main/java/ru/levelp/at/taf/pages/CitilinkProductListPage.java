package ru.levelp.at.taf.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.taf.pages.component.ProductCardComponent;

public class CitilinkProductListPage extends CitilinkAbstractBasePage {

    private static final By PRODUCT_CARD_LIST_LOCATOR =
        By.xpath("//section[contains(@class, 'ProductGroupList')]/div");

    @FindBy(xpath = "//section[contains(@class, 'ProductGroupList')]/div")
    private List<WebElement> productCardsList;

    public CitilinkProductListPage(WebDriver driver) {
        super(driver);
    }

    public ProductCardComponent productCard(int productCardIndex) {
        List<WebElement> productCardList =
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(PRODUCT_CARD_LIST_LOCATOR, 3));

        List<ProductCardComponent> list = productCardList
            .stream()
            .map(productCard -> new ProductCardComponent(driver, productCard))
            .collect(Collectors.toList());

        return list.get(productCardIndex);
    }
}
