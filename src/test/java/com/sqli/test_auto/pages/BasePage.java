package com.sqli.test_auto.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    /*** different useful objects */
    protected static WebDriver driver;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static Actions actions;
    private static JavascriptExecutor javascriptExecutor;
    private static WebDriverWait wait;
    /*************************** base page : communes action and elements between all pages. */
    public static final String COOKIES_BUTTON = "//button[@id='onetrust-accept-btn-handler']";
    public static final String WAITING_ICON = "//div[@class='loading-mask']";
    public static final String SUBSCRIBE_POPUP_CLOSE_BUTTON = "//aside[contains(@class, ' email')]//button";
    @FindBy(xpath = COOKIES_BUTTON)
    private WebElement coockiesButton;
    @FindBy(xpath = WAITING_ICON)
    private WebElement waitedIcon;
    @FindBy(xpath = SUBSCRIBE_POPUP_CLOSE_BUTTON)
    private WebElement subscribePopupCloseButton;


    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public void clickCoockiesButton() {
        coockiesButton.click();
    }

    public void waitLoading(){
        waitInvisibilityOfElement(waitedIcon);
    }

    public void closeSubscribePopupWindow(){
        subscribePopupCloseButton.click();
    }

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
        attributesInitializing();
    }

    public static void closeDriver(){
        driver.quit();
    }
    private static void attributesInitializing() {
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver,TIMEOUT);
    }
    /*** Useful actions ***/

    protected static void hoverOnElement(WebElement element){
        actions.moveToElement(element).perform();
    }

    protected static void scrollToElement(WebElement element){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected static void waitInvisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected static void waitVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected static void waitPageToLoadCompletely() {
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected static void waitUntilPresentOf(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected static void waitUntilTextOfElementNotToBe(By element, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(element, text)));
    }

    protected void clickOn(WebElement element){
        element.click();
        waitLoading();
    }

    /**********************************************************************************************************************/

}
