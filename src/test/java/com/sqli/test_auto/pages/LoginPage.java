package com.sqli.test_auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public static final String EMAIL_LOCATOR = "//form[@class = 'header-login-form']//input[@id = 'email']";
    public static final String PASSWORD_LOCATOR = "//form[@class = 'header-login-form']//input[@id = 'pass']";
    public static final String LOGING_BUTTON_LOCATOR = "//form[@class = 'header-login-form']//button[contains(@class, 'login')]";
    @FindBy(xpath = EMAIL_LOCATOR)
    private WebElement emailInput;
    @FindBy(xpath = PASSWORD_LOCATOR)
    private WebElement passwordInput;
    @FindBy(xpath = LOGING_BUTTON_LOCATOR)
    private WebElement loginButton;

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void login(){
        clickOn(loginButton);
    }
}
