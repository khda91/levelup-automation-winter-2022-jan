package ru.levelp.at.taf.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CitilinkIndexPage extends CitilinkAbstractBasePage {

    public CitilinkIndexPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Citilink index page")
    public void open() {
        open("");
    }
}
