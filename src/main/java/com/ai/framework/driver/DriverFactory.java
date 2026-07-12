package com.ai.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ai.framework.utils.ConfigReader;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()) {

                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    prefs.put("profile.password_manager_leak_detection", false);
                    prefs.put("autofill.profile_enabled", false);
                    prefs.put("autofill.address_enabled", false);
                    prefs.put("autofill.credit_card_enabled", false);

                    options.setExperimentalOption("prefs", prefs);

                    options.addArguments("--incognito");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-save-password-bubble");
                    options.addArguments("--disable-features=PasswordManagerEnabled,AutofillServerCommunication");

                    driver = new ChromeDriver(options);
                    break;

                default:
                    throw new RuntimeException("Browser not supported");
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}