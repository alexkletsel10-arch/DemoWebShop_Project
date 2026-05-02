package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.cellphone.CellPhonePage;
import com.webShop.pages.topmenu.ElectronicsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver)
                .selectElectronics();
    }
    @Test
    public void deletePhoneFrom() {
        new ElectronicsPage(driver)
                .selectCellPhones();

        new CellPhonePage(driver)
                .addToCartSmartPhone()
                .closeNitificationSuccess()
                .clickOnShoppingCartLink()
                .selectChecbox()
                .clickOnUpdateButton()
                .verifyThatItemDeleted();



    }
}
