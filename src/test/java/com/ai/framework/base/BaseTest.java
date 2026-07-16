package com.ai.framework.base;

import com.ai.framework.driver.DriverFactory;
import com.ai.framework.retry.RetryListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.ai.framework.listeners.TestListener;

@Listeners({
        TestListener.class,
        RetryListener.class
}) //register listeners

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}