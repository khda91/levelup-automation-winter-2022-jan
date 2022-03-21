package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverFactoryTest {

    @DataProvider
    public Object[][] browserNameDataProvider() {
        return new Object[][] {
            {BrowserName.CHROME},
            {BrowserName.EDGE}
        };
    }

    @Test(dataProvider = "browserNameDataProvider")
    public void createDriverTest(BrowserName browserName) {
        var driver = WebDriverFactory.createDriver(browserName);
        SleepUtils.sleep(2000);
        driver.quit();
    }
}
