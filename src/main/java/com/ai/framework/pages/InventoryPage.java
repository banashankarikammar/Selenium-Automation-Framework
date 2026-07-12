package com.ai.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By pageTitle = By.className("title");

    private By cartIcon = By.className("shopping_cart_link");

    // Methods
    public String getPageTitle() {
        return actions.getText(pageTitle);
    }

    public void addProductToCart(String productName) {

        By addButton = By.xpath(
                "//div[text()='" + productName +
                        "']/ancestor::div[@class='inventory_item']//button");

        wait.waitForVisibility(addButton);
        actions.click(addButton);
    }

    public void openCart() {
        wait.waitForClickable(cartIcon);
        actions.click(cartIcon);
        wait.waitForUrlContains("cart.html");
        System.out.println(driver.getCurrentUrl());
    }
}