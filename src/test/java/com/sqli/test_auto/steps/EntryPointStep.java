package com.sqli.test_auto.steps;

import com.sqli.test_auto.pages.*;
import com.sqli.test_auto.tests.CucumberBaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.sqli.test_auto.utilities.Utilities.logger;
import static com.sqli.test_auto.utilities.Utilities.pause;


public class EntryPointStep extends CucumberBaseTest {
    private LandingPage landingPage;

    @Before
    public void initiateDriver(){
        setupDriver();
        logger.warn("No landing page");
        landingPage = new LandingPage();
        landingPage.waitLoading();
        landingPage.clickCoockiesButton();
        landingPage.closeSubscribePopupWindow();
        //pause(2);
    }

    @Given("from the landing page")
    public void from_the_landing_page() {
        //already at the landing page.
        logger.warn("You see this message because the logger is doing its job");
    }

    @After
    public void destruct(Scenario scenario){
        failedScenarioScreenShot(scenario);
        tearDown();
    }

}
