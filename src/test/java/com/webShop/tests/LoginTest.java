package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.LoginPage;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviders;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        HomePage homePage = new HomePage(driver);
        if (!homePage.isLoginLinkPresent()) {
            homePage.clickOnLogOutLinkIfPresent();

        }
    }

    @Test(dataProvider = "LoginCsv", dataProviderClass = DataProviders.class)
    public  void loginFormPositiveTest(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillInLoginFields(loginEmail, loginPassword)
                .clickOnLoginButton()
                .verifyLogOutLinkIsPresent();

    }

    @Test(dataProvider = "LoginCsv", dataProviderClass = DataProviders.class)
    public void loginFormPositiveTestWithCheckBox(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillInLoginFields(loginEmail, loginPassword)
                .markCheckBox()
                .clickOnLoginButton()
                .verifyLogOutLinkIsPresent();

    }

    @Test(dataProvider = "loginCsvInvalidValues", dataProviderClass = DataProviders.class)
    public void loginFormNegativeTestPasswordInvalidValues(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillInLoginFields(loginEmail, loginPassword)
                .markCheckBox()
                .clickOnLoginButtonError().
                 verifyErrorMessageIsPresent("Login was unsuccessful. Please correct the errors and try again.");

    }
    @Test(dataProvider = "loginPageCsvEmptyPasswordField", dataProviderClass = DataProviders.class)
    public void loginFormNegativeTestEmptyPasswordField(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillLoginFields(loginEmail,loginPassword)
                .markCheckBox()
                .clickOnLoginButtonError()
                .verifyErrorMessageIsPresent("Login was unsuccessful. Please correct the errors and try again.");
    }
    @Test(dataProvider = "loginPageCsvInvalidEmailField", dataProviderClass = DataProviders.class)
    public void loginFormNegativeTestInvalidEmailField(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillLoginFields(loginEmail,loginPassword)
                .markCheckBox()
                .clickOnLoginButtonError()
                .verifyErrorMessageIsPresentEmailField("Please enter a valid email address.");
    }
    @Test(dataProvider = "loginPageCsvEmptyEmailField", dataProviderClass = DataProviders.class)
    public void loginFormNegativeTestEmptyEmailField(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillLoginFields(loginEmail,loginPassword)
                .markCheckBox()
                .clickOnLoginButtonError()
                .verifyErrorMessageIsPresent("Login was unsuccessful. Please correct the errors and try again.");
    }

    }





