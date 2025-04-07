package com.defenitions;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.action.LoginActions;
import com.action.NewsletterActions;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPagDefenitions {
    private final LoginActions loginActions;
    private final NewsletterActions newsletterActions;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPagDefenitions() {
        this.driver = HelperClass.getDriver();
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        this.loginActions = new LoginActions();
        this.newsletterActions = new NewsletterActions(driver);
    }

    // Login steps
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        HelperClass.openPage("https://demowebshop.tricentis.com/login");
    }

    @When("the user enters email {string} and password {string}")
    public void the_user_enters_email_and_password(String email, String password) {
        loginActions.login(email, password);
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginActions.isLoginSuccessful(),
                "User was not logged in successfully");
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        Assert.assertTrue(loginActions.isErrorMessageDisplayed(),
                "Error message was not displayed");
    }

    // Newsletter steps
    @When("the user enters {string} for newsletter subscription")
    public void the_user_enters_for_newsletter_subscription(String email) {
        newsletterActions.subscribe(email);
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String expectedMessage) {
        String actualMessage = newsletterActions.getSubscriptionResult();
        Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(),
                "Expected message does not match actual message.");
    }

}