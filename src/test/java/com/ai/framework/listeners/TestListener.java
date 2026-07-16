package com.ai.framework.listeners;

import com.ai.framework.driver.DriverFactory;
import com.ai.framework.reports.ExtentManager;
import com.ai.framework.reports.ExtentReport;
import com.ai.framework.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ExtentManager.getExtentReport();

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                ExtentManager.getExtentReport()
                        .createTest(result.getMethod().getMethodName());

        ExtentReport.setTest(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentReport.getTest().pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentReport.getTest().fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getMethod().getMethodName());

        try {

            ExtentReport.getTest()
                    .fail("Screenshot",
                            MediaEntityBuilder
                                    .createScreenCaptureFromPath(screenshotPath)
                                    .build());
        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getExtentReport().flush();

    }

}