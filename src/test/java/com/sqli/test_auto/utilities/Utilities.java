package com.sqli.test_auto.utilities;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

    public static Logger logger = LoggerFactory.getLogger(Utilities.class);

    public static void main(String[] args) {
        System.out.println(getProperty("url"));
    }
    public static void pause(int timeoutInSeconds){
        try {
            Thread.sleep(timeoutInSeconds* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
            String propertyValue = properties.getProperty(property);
            return propertyValue;
        } catch (IOException  e) {
            return null;
        }
    }

    public static int getIntegerProperty(String property){
        try{
           return Integer.parseInt(getProperty(property));
        }catch(NumberFormatException nfe){
            nfe.printStackTrace();
            logger.error(nfe.getMessage());
            return 0;
        }
    }



}
