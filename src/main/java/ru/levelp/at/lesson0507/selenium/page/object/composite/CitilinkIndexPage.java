package ru.levelp.at.lesson0507.selenium.page.object.composite;

import org.openqa.selenium.WebDriver;

public class CitilinkIndexPage extends CitilinkAbstractBasePage {

    public CitilinkIndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }
}
