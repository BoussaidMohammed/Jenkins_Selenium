package com.sqli.test_auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {
    public static final String ADD_TO_CART_BUTTON_LOCATOR = "//button[contains(@class, 'pdpcart-btn')]";
    @FindBy(xpath = ADD_TO_CART_BUTTON_LOCATOR)
    private WebElement addTocCartButton;
    private WebElement quantityInput;

    public void addProductToCart(int quantity){
        clickOn(addTocCartButton);
        try {
            By quantityLocator = By.xpath("//form//span[@data-qtyitem=" + quantity + "]");
            quantityInput = driver.findElement(quantityLocator);
            clickOn(quantityInput);
        } catch (NoSuchElementException e) {
            By qtyInputXpath = By.xpath("//input[@id = 'qty']");
            quantityInput = driver.findElement(qtyInputXpath);
            quantityInput.sendKeys(String.valueOf(quantity));
            By okButtonXpath = By.xpath("//button[@id='product-addtocart-button']");
            WebElement okButton = driver.findElement(okButtonXpath);
            clickOn(okButton);
        }
    }
}
