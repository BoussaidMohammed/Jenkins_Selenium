package com.sqli.test_auto.tests;

import com.sqli.test_auto.pages.*;
import com.sqli.test_auto.utilities.Utilities;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 extends BaseTest{
    private LandingPage landingPage;
    private Navbar navbar;
    private HeaderPage header;
    private CafeCatalogue originalCafeCatalogue;
    private CartPage cart;

    @Test(priority = 0)
    public void navigateToCafeOriginalCatalogue(){
        landingPage.waitLoading();
        landingPage.clickCoockiesButton();
        landingPage.closeSubscribePopupWindow();
        navbar.cafeMenu();
      //  navbar.cafeOriginalCatalogue();
        originalCafeCatalogue = new CafeCatalogue();
    }

    @Test(dependsOnMethods = "navigateToCafeOriginalCatalogue")
    @Parameters({"capsule", "capsuleQty"})
    public void shopCafeCapsule(String name, int quantity){
        originalCafeCatalogue.shopCafeItem(name, quantity);
        originalCafeCatalogue.waitLoading();
    }

    @Test(dependsOnMethods = "shopCafeCapsule")
    @Parameters({"capsule", "capsuleQty"})
    public void isProductExistInCart(String name, int quantity){
        header.goToCart();
        boolean isExistProductExistInCart = cart.isProductPresent(name, quantity);
        Assert.assertTrue(isExistProductExistInCart);
    }

    @Test(dependsOnMethods = "isProductExistInCart")
    public void proceedToCheckout(){

    }

    @BeforeTest
    private void pagesInitialization(){
        this.landingPage = new LandingPage();
        this.navbar = new Navbar();
        this.header = new HeaderPage();
        this.cart = new CartPage();
    }
}
