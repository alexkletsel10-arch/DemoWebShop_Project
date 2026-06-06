package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.LoginPage;
import com.webShop.pages.topmenu.ElectronicsPage;
import data.TestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyCameraTestAddQuantity extends TestBase{

    @BeforeMethod
    public void precondition() {
        loginAsRegisteredUser();
    }
    @Test
    public void makeCameraPurchaseWithExistingAddress(){
        new HomePage(driver)
                .selectElectronics();
        new ElectronicsPage(driver)
                .selectCamera()
                .clickOnSLRCamera()
                .increaseQuantity()
                .addToCart()
                .closeGreenSuccesBar()
                .openShoppingCart()
                .selectCountrys("United States")
                .markTermsAndConditionsCheckBox()
                .clickOnCheckOutButton()
                .clickOnContinueButtonUnderAddress()
                .selectContinueAtShippingAddress()
                .selectShippingOption1()
                .selectPaymentMethodCreditCard()
                .enterPaymentInfo("Master card",
                        "Alberto Denunso",
                        "12345567",
                        "06",
                        "2030",
                        "344")
                .clickOnConfirmButton().
                verifySuccesfullyProccededCheckOut();

    }
    @Test
    public void makeCameraPurchaseWithNewBillingAddress() {
        new HomePage(driver)
                .selectElectronics();

        new ElectronicsPage(driver)
                .selectCamera()
                .clickOnSLRCamera()
                .increaseQuantity()
                .addToCart()
                .closeGreenSuccesBar()
                .openShoppingCart()
                .selectCountrys("United States")
                .markTermsAndConditionsCheckBox()
                .clickOnCheckOutButton()
                .fillInBillingAddress(
                        "United States",
                        "Chicago",
                        "arcadia lane",
                        "60047",
                        "33452249901"
                )
                .clickOnContinueButtonUnderAddress()
                .selectContinueAtShippingAddress()
                .selectShippingOption1()
                .selectPaymentMethodCreditCard()
                .enterPaymentInfo("Master card",
                        "Alberto Denunso",
                        "12345567",
                        "06", "2030",
                        "344")
                .clickOnConfirmButton()
                .verifySuccesfullyProccededCheckOut();
    }
}
