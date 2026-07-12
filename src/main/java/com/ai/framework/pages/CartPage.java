package com.ai.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By checkoutButton = By.id("checkout");

    public boolean isProductPresent(String productName) {

        By product = By.xpath("//div[text()='" + productName + "']");

        wait.waitForVisibility(product);

        return actions.isDisplayed(product);
    }


   /* public void proceedToCheckout() {

        wait.waitForVisibility(checkoutButton);

        actions.click(checkoutButton);
        System.out.println(driver.getCurrentUrl());

    }*/
   public void proceedToCheckout() {
       wait.waitForVisibility(checkoutButton);
       actions.click(checkoutButton);
       wait.waitForUrlContains("checkout-step-one.html");
       System.out.println(driver.getCurrentUrl());
   }


}