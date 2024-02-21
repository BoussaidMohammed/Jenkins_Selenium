package com.sqli.test_auto.steps;

import com.sqli.test_auto.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {
    private LandingPage landingPage;
    private Navbar navbar;
    private HeaderPage header;
    private CafeCatalogue cafeCatalogue;
    private MachineCatalogue machineCatalogue;
    private ProductDetailPage machineProductDetailPage;
    private CartPage cart;


    @Given("^navigate To (.+) cafe catalogue$")
    public void navigateToCafeCatalogue(String type){
        navbar = new Navbar();
        navbar.cafeMenu();
        navbar.cafeCatalogue(type);
    }

    @When("^shopping the (.+) cafe  with quantity of (.+)$")
    public void shoppingACafeCapsule(String name, int quantity){
        cafeCatalogue = new CafeCatalogue();
        cafeCatalogue.shopCafeItem(name, quantity);
    }

    @And("^navigate To (.+) machine catalogue$")
    public void navigateToMachineCatalogue(String type){
        navbar = new Navbar();
        navbar.machineMenu();
        navbar.machineCatalogue(type);
    }

    @And("^shopping the (.+) cafe capsule with (.+)$")
    public void shoppingACafeMachine(String machine, int quantity){
        machineCatalogue = new MachineCatalogue();
        machineCatalogue.pdpOfProduct(machine);
        machineProductDetailPage = new ProductDetailPage();
        machineProductDetailPage.addProductToCart(quantity);
    }

    @Then("^the (.+) with the quantity (.+) should exist in cart$")
    public void productShouldExistInCart(String product, int productQty){
        header = new HeaderPage();
        header.goToCart();
        cart = new CartPage();
        boolean isCafeExistProductExistInCart = cart.isProductPresent(product, productQty);
        Assert.assertTrue(isCafeExistProductExistInCart);
        cart.continueShopping();
    }


}
