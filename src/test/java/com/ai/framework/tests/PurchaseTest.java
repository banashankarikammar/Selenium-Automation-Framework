package com.ai.framework.tests;

import com.ai.framework.base.BaseTest;
import com.ai.framework.constants.FrameworkConstants;
import com.ai.framework.dataproviders.ExcelDataProvider;
import com.ai.framework.pages.*;
import com.ai.framework.retry.RetryAnalyzer;
import com.ai.framework.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(PurchaseTest.class);

    // Add this import

    @Test(
            dataProvider = "loginData",
            dataProviderClass = ExcelDataProvider.class,
            retryAnalyzer = RetryAnalyzer.class
    )
    public void verifyUserCanAddProductToCart(String username,
                                              String password) {

        logger.info("Launching SauceDemo Application");

        driver.get(ConfigReader.getProperty("url"));

        LoginPage login = new LoginPage(driver);

        logger.info("Logging in with valid credentials");

        login.login(username, password);

        logger.info("Login Successful");

        InventoryPage inventory = new InventoryPage(driver);

        inventory.addProductToCart(FrameworkConstants.BACKPACK);

        logger.info("Product added to cart: {}", FrameworkConstants.BACKPACK);

        inventory.openCart();

        logger.info("Cart opened");

        CartPage cart = new CartPage(driver);

        Assert.assertTrue(
                cart.isProductPresent(FrameworkConstants.BACKPACK)
        );
        //Assert.assertTrue(false);

        logger.info("Product verified successfully in cart");

        cart.proceedToCheckout();

        logger.info("Navigated to Checkout Information page");

        CheckoutInformationPage checkout =
                new CheckoutInformationPage(driver);

        checkout.enterCheckoutInformation(
                "Banashankari",
                "Kammar",
                "580030"
        );

        logger.info("Checkout information entered");

        CheckoutOverviewPage overview =
                new CheckoutOverviewPage(driver);

        Assert.assertEquals(
                overview.getPageTitle(),
                FrameworkConstants.CHECKOUT_OVERVIEW
        );

        logger.info("Checkout Overview page verified");

        overview.clickFinish();

        logger.info("Finish button clicked");

        OrderConfirmationPage confirmation =
                new OrderConfirmationPage(driver);

        Assert.assertEquals(
                confirmation.getConfirmationMessage(),
                FrameworkConstants.ORDER_SUCCESS_MESSAGE
        );

        logger.info("Order placed successfully");

    }

}