package com.sqli.test_auto.pages;

import com.sqli.test_auto.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CafeCatalogue extends ProductListPage{
    private WebElement addProductToCartButton;
    private WebElement quantityInput;

    public void shopCafeItem(String capsule, int qty) {
        selectAProductByItsName(capsule);
        By addToCartButtonXpath = By.xpath(".//form/button");
        addProductToCartButton = productItem.findElement(addToCartButtonXpath);
        clickOn(addProductToCartButton);
        try {
            By quantiyXpath = By.xpath(".//form//span[@data-qtyitem=" + qty + "]");
            quantityInput = productItem.findElement(quantiyXpath);
            clickOn(quantityInput);
        } catch (NoSuchElementException e) {
            By qtyInputXpath = By.xpath(".//input[@class='qty-selector-input']");
            quantityInput = productItem.findElement(qtyInputXpath);
            quantityInput.sendKeys(String.valueOf(qty));

            By okButtonXpath = By.xpath(".//button[@class='qty-selector-btn']");
            WebElement okButton = productItem.findElement(okButtonXpath);
            clickOn(okButton);
        }
    }


}
