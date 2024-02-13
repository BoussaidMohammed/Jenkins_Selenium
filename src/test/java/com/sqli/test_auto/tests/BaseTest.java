package com.sqli.test_auto.tests;

import com.sqli.test_auto.pages.BasePage;
import com.sqli.test_auto.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;
import static com.sqli.test_auto.utilities.Utilities.*;
public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ma.buynespresso.com/ma_fr/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        setupDriverForPages();
    }

    private void setupDriverForPages(){
        BasePage.setDriver(driver);
    }

    @AfterTest
    public void tearDown(){
        Utilities.pause(4);
        driver.close();
    }
}
