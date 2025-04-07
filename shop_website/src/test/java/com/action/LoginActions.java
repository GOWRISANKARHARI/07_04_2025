package com.action;

import com.pages.LoginPage;
import com.utilities.HelperClass;

public class LoginActions {
    private LoginPage loginPage;
    
    public LoginActions() {
        this.loginPage = new LoginPage(HelperClass.getDriver());
    }
    
    public void login(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    
    public boolean isLoginSuccessful() {
        String currentUrl = HelperClass.getDriver().getCurrentUrl();
        return currentUrl.equals("https://demowebshop.tricentis.com/") || 
               currentUrl.equals("https://demowebshop.tricentis.com");
    }
    
    public boolean isErrorMessageDisplayed() {
        return loginPage.isErrorMessageDisplayed();
    }
}