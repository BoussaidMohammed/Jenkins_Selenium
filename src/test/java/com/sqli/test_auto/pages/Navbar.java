package com.sqli.test_auto.pages;

import com.sqli.test_auto.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navbar extends BasePage{
    public static final String CAFE_MENU_LINK_LOCATOR = "//a[contains(@href, 'cafe.html')]";
    public static final String MACHINE_MENU_LINK_LOCATOR = "//a[contains(@href, 'machines.html')]";
    @FindBy(xpath = CAFE_MENU_LINK_LOCATOR)
    private WebElement cafeMenuLink;
    @FindBy(xpath = MACHINE_MENU_LINK_LOCATOR)
    private WebElement machineMenuLink;

    public void cafeMenu(){

        hoverOnElement(cafeMenuLink);
    }

    public void machineMenu(){
        hoverOnElement(machineMenuLink);
    }

    public void cafeCatalogue(String type){
        WebElement cafeCatalogueType = driver.findElement(By.xpath("//a[contains(@href, 'cafe/"+type+".html')]"));
        try{
            clickOn(cafeCatalogueType);
        }catch(TimeoutException te){
           cafeMenu();
           cafeCatalogue(type);
        }

    }

    public void machineCatalogue(String type){
        WebElement machineCatalogueType = driver.findElement(By.xpath("//a[contains(@href, 'machines/"+type+".html')]"));
        clickOn(machineCatalogueType);
    }

}
