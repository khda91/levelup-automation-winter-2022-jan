package ru.levelp.at.lesson0507.selenium.page.object.fluent.userbugred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedIndexPage extends AbstractUserBugRedPage {

    @FindBy(css = ".navbar-nav .dropdown-toggle")
    private WebElement usernameDropdown;

    public UserBugRedIndexPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return wait.until(ExpectedConditions.visibilityOf(usernameDropdown)).getText();
    }
}
