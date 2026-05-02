package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.GiftCardPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplyGiftCardTests extends TestBase{
    @BeforeMethod
    public void selectGiftCard(){
       new HomePage(driver)
               .selectGiftCards();
    }
    @Test
    public void addGiftCardToCart(){
        new GiftCardPage(driver)
                .selectGiftCardWithAmount()
                .fillInYourName()
                .fillInRecipientsName()
                .fillInMassageField()
                .clickOnAddToCart()
                .closeGreenMassegeBar()
                .openOnShoppingCart()
                .verifyThatCardAddedToShoppingCart();
    }
}
