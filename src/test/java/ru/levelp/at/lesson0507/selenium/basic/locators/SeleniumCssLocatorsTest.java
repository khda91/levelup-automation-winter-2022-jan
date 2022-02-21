package ru.levelp.at.lesson0507.selenium.basic.locators;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.basic.SeleniumBaseTest;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumCssLocatorsTest extends SeleniumBaseTest {

    @Test
    public void idLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "idLocatorTest")));

        WebElement categories = driver.findElement(By.cssSelector("#tab-1-100680616"));
        // WebElement categories = driver.findElement(By.cssSelector("[id='tab-1-100680616']"));

        System.out.println(categories.getText());
        assertThat(categories.isDisplayed()).isTrue();
    }

    @Test
    public void classNameLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "classNameLocatorTest")));

        WebElement catalogButton = driver.findElement(By.cssSelector(".MainHeader__catalog"));
        // WebElement catalogButton = driver.findElement(By.cssSelector("[class='MainHeader__catalog']"));

        System.out.println(catalogButton.getText());
        assertThat(catalogButton.isDisplayed()).isTrue();
    }

    @Test
    public void nameLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "nameLocatorTest")));

        List<WebElement> searchTextFields = driver.findElements(By.cssSelector("[name='text']"));
        WebElement searchTextField = searchTextFields.get(1);

        searchTextField.sendKeys("iPhone");
        System.out.println("| " + searchTextField.getText() + " |");
        System.out.println("| " + searchTextField.getAttribute("value") + " |");
        assertThat(searchTextField.isDisplayed()).isTrue();
    }

    @Test
    public void combineSearchLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "combineSearchLocatorTest")));

        SleepUtils.sleep(1500);

        var compareButton = driver.findElement(By
            .cssSelector("div.HeaderMenu__button_compare div.IconAndTextWithCount__text"));
        // By.cssSelector("div[clas='HeaderMenu__button_compare'] div[class='IconAndTextWithCount__text']")

        System.out.println("| " + compareButton.getText() + " |");
        assertThat(compareButton.isDisplayed()).isTrue();
    }

    @Test
    public void tagNameLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "tagNameLocatorTest")));

        var tags = driver.findElements(By.cssSelector("a"));

        System.out.println("Amount of tags 'a' on page: " + tags.size());
    }
}
