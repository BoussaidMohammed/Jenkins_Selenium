package com.sqli.test_auto.pages;

import com.sqli.test_auto.tests.CucumberBaseTest;
import com.sqli.test_auto.utilities.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BasePage {
    protected WebElement productItem;
    public void selectAProductByItsName(String name){
        By productItemXpath = By.xpath("//a[contains(text(),'" + name + "')]/ancestor::li[1]");
        productItem = driver.findElement(productItemXpath);
        hoverOnElement(productItem);
    }


}
