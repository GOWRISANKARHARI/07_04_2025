package com.runner;

import org.testng.annotations.Listeners;
import com.utilities.ListenersClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(ListenersClass.class)
@CucumberOptions(
    features = {
    		"src/test/resources/feature"
    	//"src/test/resources/com/feature/newsletter.feature"
        //"src/test/resources/com/feature/checkout.feature"
    	
    },
    glue = {"com.defenitions"},

    plugin = {
            "pretty",
            "html:target/cucumber-reports1.html",
            "json:target/cucumber1.json",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class runnerTestNG extends AbstractTestNGCucumberTests {

}