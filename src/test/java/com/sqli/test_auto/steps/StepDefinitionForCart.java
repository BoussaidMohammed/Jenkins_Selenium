package com.sqli.test_auto.steps;

import com.sqli.test_auto.pages.*;
import com.sqli.test_auto.tests.CucumberBaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinitionForCart extends CucumberBaseTest {
    private LandingPage landingPage;
    private Navbar navbar;
    private HeaderPage header;
    private CafeCatalogue cafeCatalogue;
    private MachineCatalogue machineCatalogue;
    private ProductDetailPage machineProductDetailPage;
    private CartPage cart;

    @Before
    public void initiateDriver(){
        setupDriver();
        navbar = new Navbar();
        header = new HeaderPage();
        cart = new CartPage();
        landingPage = new LandingPage();
        landingPage.waitLoading();
        landingPage.clickCoockiesButton();
        landingPage.closeSubscribePopupWindow();
    }

    @Given("from the landing page")
    public void from_the_landing_page() {
        //always on the landing page.
    }

    @Given("^navigate To (.+) cafe catalogue$")
    public void navigateToCafeCatalogue(String type){
        navbar.cafeMenu();
        /*
        if("original".equals(type)){
            navbar.cafeOriginalCatalogue();
        }else{
            navbar.cafeVertuoCatalogue();
        }*/
        navbar.cafeCatalogue(type);
        cafeCatalogue = new CafeCatalogue();

    }

    @When("^shopping the (.+) cafe  with quantity of (.+)$")
    public void shoppingACafeCapsule(String name, int quantity){
        cafeCatalogue.shopCafeItem(name, quantity);
        header.waitUntilCartQtyCounterNumberIsVisible();
    }

    @And("^navigate To (.+) machine catalogue$")
    public void navigateToMachineCatalogue(String type){
        navbar.machineMenu();
        navbar.machineCatalogue(type);
        machineCatalogue = new MachineCatalogue();
    }

    @And("^shopping the (.+) cafe capsule with (.+)$")
    public void shoppingACafeMachine(String machine, int quantity){
        machineCatalogue.pdpOfProduct(machine);
        machineProductDetailPage = new ProductDetailPage();
        machineProductDetailPage.addProductToCart(quantity);
    }

    @Then("^the (.+) with the quantity (.+) and the (.+) with quantity of (.+) both should exist in cart$")
    public void cafeShouldExistInCart(String capsule, int capsuleQuantity, String machine, int machineQuantity){
        header.waitQtyCartCounterNumberToChangeItsValue();
        header.goToCart();
        boolean isMachineExistProductExistInCart = cart.isProductPresent(machine, machineQuantity);
        boolean isCafeExistProductExistInCart = cart.isProductPresent(capsule, capsuleQuantity);
        Assert.assertTrue(isMachineExistProductExistInCart);
        Assert.assertTrue(isCafeExistProductExistInCart);
    }

    @After
    public void destruct(){
        tearDown();
    }



}
