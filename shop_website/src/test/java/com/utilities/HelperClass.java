package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HelperClass {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public static final int TIMEOUT = 20;
    
    public static WebDriver getDriver() {
        if (driver == null) {
           // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        return driver;
    }
    
    public static void openPage(String url) {
        getDriver().get(url);
    }
    
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    public static void waitForPageLoad() {
        getWait().until(driver -> 
            ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
    }
    
    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        }
        return wait;
    }
    
    public static void takeScreenshot(String name) {
        try {
            // Implement screenshot logic if needed
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}