package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.footer.EditAddressPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountAddress extends TestBase{
    @BeforeMethod
    public void openAddressPage(){
        loginAsRegisteredUser();
    }
    @Test
    public void editUsersAddress(){
        new HomePage(driver)
                .clickOnAddressLink();
        new EditAddressPage(driver)
                .clickOnEditButton()
                .selectCountry("Belgium")
                .enterCity("Bruges")
                .enterAddress("2 Jan-Clod")
                .enterZipCode("1112233")
                .enterPhoneNumber("33478990876")
                .clickOnSaveButton()
                .verifyTitle();

    }
}
