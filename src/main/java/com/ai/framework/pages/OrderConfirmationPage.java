package com.ai.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By confirmationMessage =
            By.className("complete-header");

    public String getConfirmationMessage() {

        return actions.getText(confirmationMessage);

    }

}