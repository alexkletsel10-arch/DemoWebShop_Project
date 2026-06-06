package com.webShop.pages.registrationlogin;

import com.webShop.pages.BasePage;
import com.webShop.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    public LoginPage fillInLoginFields(String email, String password) {
        logger.info("fill in login fields" + email);
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        type(passwordField, password);

        return this;
    }
    @FindBy(css = ".button-1.login-button")
    WebElement loginButton;

    public HomePage clickOnLoginButton() {
        click(loginButton);

        return new HomePage(driver);
    }

   @FindBy(css = ".ico-logout")
   WebElement logOutLink;

    public HomePage verifyLogoutLink() {
        Assert.assertTrue(isElementDisplayed(logOutLink));

        return new HomePage(driver);
    }

   @FindBy(id = "RememberMe")
   WebElement checkBoxRememberMe;

    public LoginPage markCheckBox() {
        click(checkBoxRememberMe);

        return this;
    }

    public LoginPage clickOnLoginButtonError() {
        click(loginButton);

        return this;
    }

    @FindBy(xpath = "//span[text() = 'Login was unsuccessful. Please correct the errors and try again.']")
    WebElement errorMessage;

    public LoginPage verifyErrorMessageIsPresent(String text) {
        Assert.assertTrue(shouldHaveText(errorMessage,text,5));


        return this;
    }

    public LoginPage fillLoginFields(String email, String password) {
        logger.info("fill in login fields" + email);
        type(emailField,email);
        type(passwordField ,password);
        return this;
    }
    @FindBy(xpath ="//span[text()='Please enter a valid email address.']")
    WebElement emailFieldError;
    public LoginPage verifyErrorMessageIsPresentEmailField(String text) {
        Assert.assertTrue(shouldHaveText(emailFieldError,text,5));
        return this;
    }
    public HomePage login(String email, String password) {

        fillInLoginFields(email, password);
        clickOnLoginButton();
        return new HomePage(driver);
    }
}
