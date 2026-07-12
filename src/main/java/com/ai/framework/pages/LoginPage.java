package com.ai.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    By username = By.id("user-name");

    By password = By.id("password");

    By loginButton = By.id("login-button");

    public void enterUsername(String user){

        actions.type(username, user);

    }

    public void enterPassword(String pass){

        actions.type(password, pass);

    }

    public void clickLogin(){

        actions.click(loginButton);

    }

    public void login(String username, String password){

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

}