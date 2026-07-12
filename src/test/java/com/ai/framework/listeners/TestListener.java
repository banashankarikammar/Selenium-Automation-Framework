package com.ai.framework.listeners;

import com.ai.framework.driver.DriverFactory;
import com.ai.framework.utils.ScreenshotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getName());

        System.out.println("Screenshot Saved At : " + screenshotPath);
    }
}