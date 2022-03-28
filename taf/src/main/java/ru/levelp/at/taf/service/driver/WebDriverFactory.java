package ru.levelp.at.taf.service.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import ru.levelp.at.taf.exception.UnsupportedBrowserException;

public final class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createDriver(final BrowserName browserName) {
        WebDriver driver;

        switch (browserName) {
            case CHROME:
                driver = createChromeDriver();
                break;

            case FIREFOX:
                driver = createFirefoxDriver();
                break;

            case EDGE:
                driver = createEdgeDriver();
                break;

            case OPERA:
                driver = createOperaDriver();
                break;

            default:
                throw new UnsupportedBrowserException();
        }

        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
