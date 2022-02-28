package ru.levelp.at.lesson0507.selenium.page.object.fluent;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitilinkSearchResultPage extends CitilinkAbstractBasePage {

    @FindBy(className = "ProductCardVertical__name")
    private List<WebElement> products;

    public CitilinkSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        List<String> productTitles = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            productTitles.add(products.get(i).getText());
        }

        return productTitles;
    }
}
