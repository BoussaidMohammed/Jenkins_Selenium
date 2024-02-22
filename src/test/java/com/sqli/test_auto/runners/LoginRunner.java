package com.sqli.test_auto.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/sqli/test_auto/features/login.feature", glue = "com.sqli.test_auto.steps",
        monochrome = true, plugin = {"json:target/cucumber-reports/login-report.json", "html:target/cucumber-reports/login-report.html"})
public class LoginRunner extends TestNGTestRunner {

}

