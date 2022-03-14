package ru.levelp.at.lesson1011.cicd.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failed. Listener is running");
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        attachScreenshot(driver);
        String pageSource = driver.getPageSource();
        Allure.getLifecycle().addAttachment("Page_Source", "text/html", ".html",
            pageSource.getBytes(StandardCharsets.UTF_8));
    }

    @Attachment(fileExtension = ".png", type = "image/png", value = "screenshot")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
