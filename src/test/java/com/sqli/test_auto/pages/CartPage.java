package com.sqli.test_auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public static final String CONTINUE_SHOPPING_LOCATOR = "//button[@id = 'btn-minicart-close']";
    @FindBy(xpath = CONTINUE_SHOPPING_LOCATOR)
    private WebElement continueShoppingButton;
    private WebElement productItem;
    private WebElement quantity;

    public boolean isProductPresent(String name, int qty){
        boolean isExist = true;
        try{
            By productItemXpath = By.xpath("//a[contains(text(), '"+name+"')]/ancestor::li[1]");
            waitUntilPresenceOfElementLocated(productItemXpath);
            productItem = driver.findElement(productItemXpath);
            quantity = productItem.findElement(By.xpath(".//input[@data-item-qty = "+qty+"]"));
            System.out.println("the quatity of the product is "+quantity.getAttribute("data-item-qty"));
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            isExist = false;
        }
        return isExist;
    }

    public void continueShopping(){
        try{
            clickOn(continueShoppingButton);
        }catch (ElementClickInterceptedException e){
            //System.out.println(e.getMessage());
            hideHighlightBanner();
            clickOn(continueShoppingButton);
        }
    }
}
