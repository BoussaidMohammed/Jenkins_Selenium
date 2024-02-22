package com.sqli.test_auto.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/sqli/test_auto/features/cart.feature", glue = "com.sqli.test_auto.steps",
        monochrome = true, plugin = {"json:target/cucumber-reports/cart.json", "html:target/cucumber-reports/cart-report.html"}, tags = "@Ready")
public class CartRunner extends TestNGTestRunner {

}

