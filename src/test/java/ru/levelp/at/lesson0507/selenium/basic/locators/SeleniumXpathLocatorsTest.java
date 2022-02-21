package ru.levelp.at.lesson0507.selenium.basic.locators;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.basic.SeleniumBaseTest;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumXpathLocatorsTest extends SeleniumBaseTest {

    @Test
    public void idLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "idLocatorTest")));

        WebElement categories = driver.findElement(By.xpath("//*[@id='tab-1-100680616']"));

        System.out.println(categories.getText());
        assertThat(categories.isDisplayed()).isTrue();
    }

    @Test
    public void classNameLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "classNameLocatorTest")));

        WebElement catalogButton = driver.findElement(By.xpath("//*[@class='MainHeader__catalog']"));

        System.out.println(catalogButton.getText());
        assertThat(catalogButton.isDisplayed()).isTrue();
    }

    @Test
    public void nameLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "nameLocatorTest")));

        List<WebElement> searchTextFields = driver.findElements(By.xpath("//*[@name='text']"));
        WebElement searchTextField = searchTextFields.get(1);

        searchTextField.sendKeys("iPhone");
        System.out.println("| " + searchTextField.getText() + " |");
        System.out.println("| " + searchTextField.getAttribute("value") + " |");
        assertThat(searchTextField.isDisplayed()).isTrue();
    }

    @Test
    public void linkTextLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "linkTextLocatorTest")));

        SleepUtils.sleep(1500);

        var link = driver.findElement(By.xpath("//a[text()='Товары для рыбалки']"));

        System.out.println("| " + link.getText() + " |");
        assertThat(link.isDisplayed()).isTrue();
    }

    @Test
    public void partialLinkTextLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "partialLinkTextLocatorTest")));

        SleepUtils.sleep(1500);

        var link = driver.findElement(By.xpath("//a[contains(text(), 'машины')]"));

        System.out.println("| " + link.getText() + " |");
        assertThat(link.isDisplayed()).isTrue();
    }

    @Test
    public void tagNameLocatorTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "tagNameLocatorTest")));

        var tags = driver.findElements(By.xpath("//a"));

        System.out.println("Amount of tags 'a' on page: " + tags.size());
    }

    @Test
    public void nameLocatorWithIndexTest() {
        System.out.println(String
            .format(String.format("%s#%s", this.getClass().getSimpleName(), "nameLocatorTest")));

        var searchTextField = driver.findElement(By.xpath("//*[@name='text'][2]"));

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
            .xpath("//div[contains(@class, 'HeaderMenu__button_compare')]"
                + "//div[contains(@class, 'IconAndTextWithCount__text')]"));

        System.out.println("| " + compareButton.getText() + " |");
        assertThat(compareButton.isDisplayed()).isTrue();
    }
}
