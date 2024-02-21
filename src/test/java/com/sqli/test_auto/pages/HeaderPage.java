package com.sqli.test_auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{
    public static final String CART_LINK = "//a[@class = 'action showcart']";
    public static final String LOGGING_LOCATOR = "//span[@id= 'header-login-link']";
    @FindBy(xpath = CART_LINK)
    private WebElement cartLink;
    @FindBy(xpath = LOGGING_LOCATOR)
    private WebElement logging;

    public static final String CART_QTY_COUNTER_NUMBER_LOCATOR = "//span[@class = 'counter-number']";
    @FindBy(xpath = CART_QTY_COUNTER_NUMBER_LOCATOR)
    private WebElement cartQtyCounterNumber;

    public void goToCart(){
        clickOn(cartLink);
    }

    public void waitUntilCartQtyCounterNumberIsVisible(){
        waitVisibilityOfElement(cartQtyCounterNumber);
    }

    public void waitQtyCartCounterNumberToChangeItsValue(){
        String currentValue = cartQtyCounterNumber.getText();
        waitUntilTextOfElementNotToBe(By.xpath(CART_QTY_COUNTER_NUMBER_LOCATOR),currentValue);
    }

    public void logging(){
        clickOn(logging);
    }
}
