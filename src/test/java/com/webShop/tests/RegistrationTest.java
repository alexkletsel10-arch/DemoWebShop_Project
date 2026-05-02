package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void selectRegistration(){
        HomePage homePage = new HomePage(driver);
        if (!homePage.isLoginLinkPresent()) {
            homePage.clickOnLogOutLinkIfPresent();

        }
    }

    @Test(dataProvider = "DemoWebCsv",dataProviderClass = DataProviders.class)
    public void fillInRegistrationFormPositiveTest(String fName, String lName, String userEmail, String userPassword, String cPassword){
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver).selectRadioButton()
                .fillInRequiredFields(fName,lName,userEmail,userPassword,cPassword)
                .selectRegisterButton()
                .clickOnContinueButton()
                .verifyLogOutLinkIsPresent();

    }
    @Test(dataProvider = "DemoWebCsv",dataProviderClass = DataProviders.class)
    public void fillInRegistrationFormNegativeTest(String fName, String lName, String userEmail, String userPassword, String cPassword){
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver).selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .verifyErrorMessage("The specified email already exists");

    }
}

