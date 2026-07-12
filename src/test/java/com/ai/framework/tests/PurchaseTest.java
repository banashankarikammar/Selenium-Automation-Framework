package com.ai.framework.tests;

import com.ai.framework.base.BaseTest;
import com.ai.framework.constants.FrameworkConstants;
import com.ai.framework.pages.*;
import com.ai.framework.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest{

    @Test
    public void verifyUserCanAddProductToCart() throws InterruptedException {

        driver.get(ConfigReader.getProperty("url"));
        LoginPage login = new LoginPage(driver);

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));
        System.out.println("Login Done");

        InventoryPage inventory = new InventoryPage(driver);

        inventory.addProductToCart(FrameworkConstants.BACKPACK);
        System.out.println("Product Added");

        inventory.openCart();
        //Thread.sleep(2000);

        System.out.println(driver.getCurrentUrl());
        System.out.println("Cart Opened");

        CartPage cart = new CartPage(driver);

        Assert.assertTrue(
                cart.isProductPresent(FrameworkConstants.BACKPACK)
        );
        //Assert.assertTrue(false);
        System.out.println("Product Verified");
       // Thread.sleep(5000);
        cart.proceedToCheckout();
        System.out.println("Checkout Clicked");

        System.out.println(driver.getCurrentUrl());

        CheckoutInformationPage checkout =
                new CheckoutInformationPage(driver);

        checkout.enterCheckoutInformation(
                "Banashankari",
                "Kammar",
                "580030"
        );

        CheckoutOverviewPage overview =
                new CheckoutOverviewPage(driver);

        Assert.assertEquals(

                overview.getPageTitle(),

                FrameworkConstants.CHECKOUT_OVERVIEW

        );

        System.out.println("Checkout Overview Verified");

        overview.clickFinish();
        System.out.println("Finish Button Clicked");

        OrderConfirmationPage confirmation =
                new OrderConfirmationPage(driver);
        Assert.assertEquals(

                confirmation.getConfirmationMessage(),

                FrameworkConstants.ORDER_SUCCESS_MESSAGE

        );

        System.out.println("Order Successfully Placed");

    }

}