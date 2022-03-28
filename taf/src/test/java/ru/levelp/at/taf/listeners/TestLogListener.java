package ru.levelp.at.taf.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestLogListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("========");
        log.info(String.format("Launch test: '%s'\ntest class: '%s'\ntest method: '%s'",
                result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getName()));
        log.info("========");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("========");
        log.info(String.format("Test finished with success: '%s'\ntest class: '%s'\ntest method: '%s'",
                result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getName()));
        log.info("========");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("========");
        log.info(String.format("Test finished as failed: '%s'\ntest class: '%s'\ntest method: '%s'",
                result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getName()));
        log.info("========");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("========");
        log.info(String.format("Test was skipped: '%s'\ntest class: '%s'\ntest method: '%s'",
                result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getName()));
        log.info("========");
    }
}
