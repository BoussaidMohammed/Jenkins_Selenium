package com.sqli.test_auto.pages;

import com.sqli.test_auto.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navbar extends BasePage{
    public static final String CAFE_MENU_LINK_LOCATOR = "//a[contains(@href, 'cafe.html')]";
    public static final String MACHINE_MENU_LINK_LOCATOR = "//a[contains(@href, 'machines.html')]";
   /* public static final String CAFE_ORIGINAL_CATALOGUE_LINK_LOCATOR = "//a[contains(@href, 'cafe/original.html')]";
    public static final String CAFE_VERTUO_CATALOGUE_LINK_LOCATOR = "//a[contains(@href, 'cafe/vertuo.html')]";*/
    @FindBy(xpath = CAFE_MENU_LINK_LOCATOR)
    private WebElement cafeMenuLink;
    @FindBy(xpath = MACHINE_MENU_LINK_LOCATOR)
    private WebElement machineMenuLink;
   /* @FindBy(xpath = CAFE_ORIGINAL_CATALOGUE_LINK_LOCATOR)
    private WebElement cafeOriginalLink;
    @FindBy(xpath = CAFE_VERTUO_CATALOGUE_LINK_LOCATOR)*/
    private WebElement cafeVertuoLink;
    @FindBy(xpath = "")
    private WebElement machineOriginalLink;

    public void cafeMenu(){
        hoverOnElement(cafeMenuLink);
    }

    public void machineMenu(){
        hoverOnElement(machineMenuLink);
    }

    public void cafeCatalogue(String type){
        WebElement cafeCatalogueType = driver.findElement(By.xpath("//a[contains(@href, 'cafe/"+type+".html')]"));
        clickOn(cafeCatalogueType);
    }

    public void machineCatalogue(String type){
        WebElement machineCatalogueType = driver.findElement(By.xpath("//a[contains(@href, 'machines/"+type+".html')]"));
        clickOn(machineCatalogueType);
    }

    /*public void cafeOriginalCatalogue() {
        cafeOriginalLink.click();
        waitLoading();
    }

    public void cafeVertuoCatalogue() {
        cafeVertuoLink.click();
        waitLoading();
    }*/


}
