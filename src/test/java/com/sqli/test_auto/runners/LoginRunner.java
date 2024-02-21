package com.sqli.test_auto.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/sqli/test_auto/features/login.feature", glue = "com.sqli.test_auto.steps",
        monochrome = true, plugin = {"json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumber.html"})
public class LoginRunner extends TestNGTestRunner {

}
