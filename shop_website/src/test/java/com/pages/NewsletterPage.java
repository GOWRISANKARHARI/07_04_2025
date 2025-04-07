package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewsletterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "newsletter-email")
    private WebElement emailField;
    
    @FindBy(id = "newsletter-subscribe-button")
    private WebElement subscribeButton;
    
    @FindBy(css = "#newsletter-result-block")
    private WebElement resultBlock;

    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSubscribe() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        subscribeButton.click();
        // Wait for the result block to update
        wait.until(driver -> !resultBlock.getText().isEmpty());
    }

    public String getResultMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(resultBlock)).getText().trim();
        } catch (Exception e) {
            return "No message found";
        }
    }
}