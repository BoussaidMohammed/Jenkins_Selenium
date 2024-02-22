package com.sqli.test_auto.tests;

import com.sqli.test_auto.pages.BasePage;
import com.sqli.test_auto.utilities.Utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static com.sqli.test_auto.utilities.Utilities.*;

public class CucumberBaseTest {
    protected WebDriver driver;
    public static final String URL = getProperty("url");
    public static final String hubURL = getProperty("cloudUrl");


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
        String executionMethod = getProperty("executionMethod");
        if("cloud".equals(executionMethod)){
            cloudDriver();
        }else{
            localDriver();
        }
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        setupDriverForPages();
    }

    private void setupDriverForPages(){
        BasePage.setDriver(driver);
    }

    protected void failedScenarioScreenShot(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            String screenshotName = scenario.getName() + "Failed screenshot";
            scenario.attach(screenshot,"image/png", screenshotName);
        }
    }
    public void tearDown(){
        Utilities.pause(2);
        driver.quit();
    }

    public void localDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void cloudDriver(){
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("121.0");
        ltOptions.put("username", "boussaidmohammed88");
        ltOptions.put("accessKey", "8effFEl0DsYk4egkWkcvztJGiI7GmdrTJL2AsgRKgJ2hrXYL63");
        ltOptions.put("build", "CloudAutomationcapabilitiesTesting");
        ltOptions.put("project", "nesspressoo");
        ltOptions.put("name", "nesspresson_demo_test");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        try{
            driver = new RemoteWebDriver(new URL(hubURL), browserOptions );
        }catch (MalformedURLException exception){
            logger.error(exception.getMessage());
        }
    }
}
