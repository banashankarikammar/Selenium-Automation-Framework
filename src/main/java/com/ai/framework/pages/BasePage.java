package com.ai.framework.pages;

import com.ai.framework.utils.CommonActions;
import com.ai.framework.utils.WaitUtility;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected CommonActions actions;
    protected WaitUtility wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        actions = new CommonActions(driver);

        wait = new WaitUtility(driver);

    }

}