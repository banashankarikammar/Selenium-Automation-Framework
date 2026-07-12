package com.ai.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    private String enteredFirstName;
    private String enteredLastName;
    private String enteredPostalCode;

    public void enterFirstName(String fname){
        wait.waitForVisibility(firstName);
        this.enteredFirstName = fname;
        actions.type(firstName, fname);
    }

    public void enterLastName(String lname){
        this.enteredLastName = lname;
        actions.type(lastName, lname);
    }

    public void enterPostalCode(String code){
        this.enteredPostalCode = code;
        actions.type(postalCode, code);
    }

    private void ensureFieldValue(By locator, String expectedValue) {
        String currentValue = driver.findElement(locator).getAttribute("value");
        if (currentValue == null || currentValue.isEmpty()) {
            actions.type(locator, expectedValue);
        }
    }

    public void clickContinue(){
        ensureFieldValue(firstName, enteredFirstName);
        ensureFieldValue(lastName, enteredLastName);
        ensureFieldValue(postalCode, enteredPostalCode);

        actions.click(continueButton);
        wait.waitForUrlContains("checkout-step-two.html");
    }

    public void enterCheckoutInformation(String first, String last, String postal) {
        enterFirstName(first);
        enterLastName(last);
        enterPostalCode(postal);
        clickContinue();
    }
}