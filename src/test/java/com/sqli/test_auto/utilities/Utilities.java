package com.sqli.test_auto.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Utilities {

    public static void main(String[] args) {
        System.out.println(getConfigProperty("url"));
    }
    public static void pause(int timeoutInSeconds){
        try {
            Thread.sleep(timeoutInSeconds* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfigProperty(String property) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
            String propertyValue = properties.getProperty(property);
            return propertyValue;
        } catch (IOException  e) {
            return null;
        }
    }



}