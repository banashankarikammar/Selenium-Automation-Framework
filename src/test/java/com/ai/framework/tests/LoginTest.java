package com.ai.framework.tests;

import com.ai.framework.base.BaseTest;
import com.ai.framework.constants.FrameworkConstants;
import com.ai.framework.pages.InventoryPage;
import com.ai.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ai.framework.utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        driver.get(ConfigReader.getProperty("url"));

        LoginPage login = new LoginPage(driver);

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        InventoryPage inventory = new InventoryPage(driver);

        String title = inventory.getPageTitle();

        Assert.assertEquals(title, FrameworkConstants.PRODUCTS_PAGE_TITLE);

    }

}