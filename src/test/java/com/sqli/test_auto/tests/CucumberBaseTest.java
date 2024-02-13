package com.sqli.test_auto.tests;

import com.sqli.test_auto.pages.BasePage;
import com.sqli.test_auto.utilities.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import static com.sqli.test_auto.utilities.Utilities.*;

public class CucumberBaseTest {
    protected WebDriver driver;
    public static final String URL = getConfigProperty("url");


    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        setupDriverForPages();
    }

    private void setupDriverForPages(){
        BasePage.setDriver(driver);
    }


    public void tearDown(){
        Utilities.pause(4);
        driver.close();
    }
}
