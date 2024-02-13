package com.sqli.test_auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MachineCatalogue extends ProductListPage{
    private WebElement machineDetailPageLink;

    public void pdpOfProduct(String machine) {
        selectAProductByItsName(machine);
        By machineDetailPageLinkLocator = By.xpath(".//div[@class = 'actions-primary']/a");
        machineDetailPageLink = productItem.findElement(machineDetailPageLinkLocator);
        clickOn(machineDetailPageLink);
    }
}
