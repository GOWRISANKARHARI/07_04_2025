package com.action;

import org.openqa.selenium.WebDriver;

import com.pages.NewsletterPage;
import com.utilities.HelperClass;

public class NewsletterActions {
    private final NewsletterPage newsletterPage;

    public NewsletterActions(WebDriver driver) {
        this.newsletterPage = new NewsletterPage(HelperClass.getDriver());
    }

    public void subscribe(String email) {
        newsletterPage.enterEmail(email);
        newsletterPage.clickSubscribe();
    }

    public String getSubscriptionResult() {
        String message = newsletterPage.getResultMessage();
        System.out.println("Actual message received: " + message); // Debug log
        return message;
    }
}