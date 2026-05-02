package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.DigitalDownloadsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddDigitalDownloadToTheCart extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver)
                .selectDigitalDownloads();
    }
    @Test
    public void DigitalDownloadAddToCartSelectQuantity(){
        new DigitalDownloadsPage(driver)
                .selectAnyDownload("3rd Album")
                .indicateQuantity("2")
                .addToCart()
                .clickOnSuccessBarNotification()
                .openShoppingCart()
                .verifyThatItemAddedSuccesfully();


    }

}
