package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import com.webShop.pages.topmenu.BooksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteFromShoppingCart extends TestBase{

    @BeforeMethod
     public void preconditions(){
        new HomePage(driver)
                .selectBookCategory()
                .addToCartMultipleBooks(3)
                .closeNitificationSuccess()
                .clickOnShoppingCartLink();

    }
    @Test
    public void deleteItemFromCart(){
        new ShoppingCartPage(driver)
                .markCheckBox()
                .clickOnUpgradeButton();

    }
    @Test
    public void removeProduct(){
        new ShoppingCartPage(driver)
                .findProductByName("Health Book")
                .clickOnUpgradeButton();


    }







}
