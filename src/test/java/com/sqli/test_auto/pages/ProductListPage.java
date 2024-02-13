package com.sqli.test_auto.pages;

import com.sqli.test_auto.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {
    protected WebElement productItem;
    public void selectAProductByItsName(String name){
        By productItemXpath = By.xpath("//a[contains(text(),'" + name + "')]/ancestor::li[1]");
        productItem = driver.findElement(productItemXpath);
        hoverOnElement(productItem);
    }
}
