package com.sqli.test_auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    private WebElement productItem;
    private WebElement quantity;

    public boolean isProductPresent(String name, int qty){
        boolean isExist = true;
        try{
            By productItemXpath = By.xpath("//a[contains(text(), '"+name+"')]/ancestor::li[1]");
            productItem = driver.findElement(productItemXpath);
            String quantity = productItem.findElement(By.xpath(".//input[@data-item-qty = "+qty+"]")).getAttribute("data-item-qty");
            System.out.println("the quatity of the product is "+quantity);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            isExist = false;
        }
        return isExist;
    }
}
