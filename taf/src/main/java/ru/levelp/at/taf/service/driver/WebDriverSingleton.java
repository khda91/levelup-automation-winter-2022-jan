package ru.levelp.at.taf.service.driver;

import java.util.Locale;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.configuration.CommonConfiguration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            var browserName = CommonConfiguration.getInstance().browserName().toUpperCase(Locale.ROOT);
            driver = WebDriverFactory.createDriver(BrowserName.valueOf(browserName));
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
