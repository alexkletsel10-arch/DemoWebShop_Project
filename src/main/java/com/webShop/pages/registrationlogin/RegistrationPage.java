package com.webShop.pages.registrationlogin;

import com.webShop.pages.BasePage;
import com.webShop.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement radioButton;

    public RegistrationPage selectRadioButton() {
        click(radioButton);

        return this;
    }

    @FindBy(id = "FirstName")
    WebElement userFirstNmae;

    @FindBy(id = "LastName")
    WebElement userLastNmae;

    @FindBy(id = "Email")
    WebElement userEmail;

    @FindBy(id = "Password")
    WebElement userPassword;

    @FindBy(id = "ConfirmPassword")
    WebElement useConfirmPassword;

    public RegistrationPage fillInRequiredFields(String firstName, String lastName, String email, String password, String confirmPassword) {
        type(userFirstNmae, firstName);
        type(userLastNmae, lastName);
        type(userEmail, email);
        type(userPassword, password);
        type(useConfirmPassword, confirmPassword);

        return this;
    }

    @FindBy(id = "register-button")
    WebElement regButton;

    public RegistrationPage selectRegisterButton() {
        click(regButton);
        return this;
    }

    @FindBy(css = ".button-1.register-continue-button")
    WebElement continueButton;

    public HomePage clickOnContinueButton() {
        click(continueButton);

        return new HomePage(driver);
    }
    @FindBy(xpath = "//li[text() = 'The specified email already exists']")
    WebElement errorMassage;

    public RegistrationPage verifyErrorMessage(String text) {
        Assert.assertTrue(shouldHaveText(errorMassage,text,5));

        return this;
    }
}
