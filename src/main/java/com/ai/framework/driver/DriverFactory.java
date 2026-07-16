package com.ai.framework.driver;

import com.ai.framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driver.get() == null) {

            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()) {

                case "chrome":

                    ChromeOptions chromeOptions = new ChromeOptions();

                    Map<String, Object> chromePrefs = new HashMap<>();

                    chromePrefs.put("credentials_enable_service", false);
                    chromePrefs.put("profile.password_manager_enabled", false);
                    chromePrefs.put("profile.password_manager_leak_detection", false);
                    chromePrefs.put("autofill.profile_enabled", false);
                    chromePrefs.put("autofill.address_enabled", false);
                    chromePrefs.put("autofill.credit_card_enabled", false);

                    chromeOptions.setExperimentalOption("prefs", chromePrefs);

                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-save-password-bubble");
                    chromeOptions.addArguments("--disable-features=PasswordManagerEnabled,AutofillServerCommunication");

                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "edge":

                    EdgeOptions edgeOptions = new EdgeOptions();

                    driver.set(new EdgeDriver(edgeOptions));

                    break;
                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }

            // These must come AFTER creating the driver
            driver.get().manage().window().maximize();
            driver.get().manage().deleteAllCookies();
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();

        }
    }
}