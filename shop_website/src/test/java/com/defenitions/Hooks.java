package com.defenitions;

import com.utilities.HelperClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before(order = 0)
    public static void setUp() {
        HelperClass.getDriver();
    }
    
    @After(order = 0)
    public static void tearDown(Scenario scenario) {
        HelperClass.closeDriver();;
    }
}