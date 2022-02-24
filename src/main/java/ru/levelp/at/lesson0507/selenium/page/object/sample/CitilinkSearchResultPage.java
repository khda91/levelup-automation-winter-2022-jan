package ru.levelp.at.lesson0507.selenium.page.object.sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitilinkSearchResultPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "ProductCardVertical__name")
    private List<WebElement> products;

    public CitilinkSearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public CitilinkSearchResultPage(WebDriver driver, long timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public List<String> getProductTitles() {
        List<String> productTitles = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            productTitles.add(products.get(i).getText());
        }

        return productTitles;
    }
}
