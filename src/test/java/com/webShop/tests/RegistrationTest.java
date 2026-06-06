package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.RegistrationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviders;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void selectRegistration() {
        HomePage homePage = new HomePage(driver);
        if (!homePage.isLoginLinkPresent()) {
            homePage.clickOnLogOutLinkIfPresent();

        }
    }

    @Test(dataProvider = "DemoWebCsv", dataProviderClass = DataProviders.class)
    public void fillInRegistrationFormPositiveTest(String fName, String lName, String userEmail, String userPassword, String cPassword) {
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver).selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .clickOnContinueButton()
                .verifyLogOutLinkIsPresent();

    }
    @Test(dataProvider = "regInvalidEmailValues",dataProviderClass = DataProviders.class)
    public void registrationInvalidEmailFieldValues(String fName, String lName, String userEmail, String userPassword, String cPassword) {
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver)
                .selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .verifyEmaiFieldErrorMessage();

    }
    @Test(dataProvider = "regInvalidPasswordValues",dataProviderClass = DataProviders.class)
    public void registrationPasswordInvalidField(String fName, String lName, String userEmail, String userPassword, String cPassword) {
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver).selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .verifyPasswordFieldErrorMessage();


}
    @Test(dataProvider = "regEmptyEmailField",dataProviderClass = DataProviders.class)
    public void registrationEmptyEmailField(String fName, String lName, String userEmail, String userPassword, String cPassword) {
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver)
                .selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .verifyEmptyEmailFieldErrorMessage();
    }
    @Test(dataProvider = "regEmptyPasswordField",dataProviderClass = DataProviders.class)
    public void registrationEmptyPasswordField(String fName, String lName, String userEmail, String userPassword, String cPassword) {
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver)
                .selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .verifyEmptyPasswordFieldErrorMessage();
    }



    @Test(dataProvider = "DemoWebCsv",dataProviderClass = DataProviders.class)
    public void fillInRegistrationFormNegativeTestAlreadyExistingAccount(String fName, String lName, String userEmail, String userPassword, String cPassword){
        new HomePage(driver)
                .selectRegistrationLink();
        new RegistrationPage(driver).selectRadioButton()
                .fillInRequiredFields(fName, lName, userEmail, userPassword, cPassword)
                .selectRegisterButton()
                .verifyErrorMessage("The specified email already exists");

    }

}

