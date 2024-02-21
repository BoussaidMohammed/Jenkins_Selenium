package com.sqli.test_auto.steps;

import com.sqli.test_auto.pages.*;
import com.sqli.test_auto.utilities.Utilities;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.sqli.test_auto.utilities.Utilities.*;

public class LoginSteps {

    private HeaderPage header;
    private LoginPage logingPage;

    @Given("from the logging page")
    public void openLoggingPage(){
        header = new HeaderPage();
        header.logging();
    }

    @When("^the user enters invalid (.+) or (.+)$")
    public void entrerCredentials(String username, String password){
       // logingPage = new LoginPage();
        logingPage.enterEmail(username);
        logingPage.enterPassword(password);
        Utilities.pause(5);
        logingPage.login();
    }

    @Then("the user should see an error message")
    public void messageErrorShouldExist(){
        logger.info("error message");
    }
}
