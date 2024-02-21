package com.sqli.test_auto.tests;

import com.sqli.test_auto.pages.BasePage;
import com.sqli.test_auto.utilities.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;
import static com.sqli.test_auto.utilities.Utilities.*;

public class CucumberBaseTest {
    protected WebDriver driver;
    public static final String URL = getConfigProperty("url");


    public void setupDriver(){
        /*
        FireforxDriver
        System.setProperty("webdriver.gecko.driver", "D:\\MyProject\\Selenium\\Udemy\\selenium-java\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        EdgeBrowsers
        System.setProperty("webdriver.edge.driver", "D:\\MyProject\\Selenium\\Udemy\\selenium-java\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        */
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
