package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.ApparelAndShoesPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddItemApparelTests extends TestBase{
    @BeforeMethod
    public void preconditions(){
        loginAsRegisteredUser();
    }
    @Test
    public void addApparelItemToCart(){
        new HomePage(driver)
                .selectApparelAndShoes();
        new ApparelAndShoesPage(driver)
                   .selectSneakers()
                   .selectColorBlack()
                   .clickOnAddToCartB()
                   .closeGreenMassegeBar()
                   .selectShoppingCartLink()
                   .applyDiscountCode()
                   .selectCountry("United States")
                   .selectStateProvince("Illinois")
                   .markCheckBoxAtCheckOut();

    }
    @Test
    public void addItemToWishList(){
        new HomePage(driver)
                .selectApparelAndShoes();
        new ApparelAndShoesPage(driver)
                .selectSneakers()
                .selectColorBlack()
                .clickOnAddToWishListButton()
                .clickOnSuccessBarNotification()
                .clickOnWishlist()
                .verifyItemSneakers();
    }
}
