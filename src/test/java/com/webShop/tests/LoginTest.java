package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.LoginPage;
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
    public  void LoginFormPositiveTest(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillInLoginFields(loginEmail, loginPassword)
                .clickOnLoginButton()
                .verifyLogOutLinkIsPresent();


    }

    @Test(dataProvider = "LoginCsv", dataProviderClass = DataProviders.class)
    public void LoginFormPositiveTestWithCheckBox(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillInLoginFields(loginEmail, loginPassword)
                .markCheckBox()
                .clickOnLoginButton()
                .verifyLogOutLinkIsPresent();


    }

    @Test(dataProvider = "loginCsvInvalidValues", dataProviderClass = DataProviders.class)
    public void LoginFormNegativeTestInvalidValues(String loginEmail, String loginPassword) {
        new HomePage(driver)
                .selectLoginLink();
        new LoginPage(driver)
                .fillInLoginFields(loginEmail, loginPassword)
                .markCheckBox()
                .clickOnLoginButtonError().
                 verifyErrorMessageIsPresent("Login was unsuccessful. Please correct the errors and try again.");


    }

}
