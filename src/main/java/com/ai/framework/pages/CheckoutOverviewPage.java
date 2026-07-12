package com.ai.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private By finishButton =
            By.id("finish");

    private By pageTitle =
            By.className("title");

    public String getPageTitle() {

        return actions.getText(pageTitle);

    }

    public void clickFinish() {

        actions.click(finishButton);

    }

}