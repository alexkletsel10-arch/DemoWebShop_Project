package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.BooksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase{

    @BeforeMethod
    public void selectBooksSection(){
        new HomePage(driver)
                .clickOnBooksLink();
    }
    @Test
    public void addBookToTheCart(){
        new BooksPage(driver)
                .selectBook()
                .clickAddToCartButton()
                .closeNitificationSuccess()
                .clickOnShoppingCartLink()
                .getProductQuantity("Health Book");
                //.isItemAdded("Computing and Internet");
    }
    @Test
    public void addMulitpleBooksToTheCart(){
        new BooksPage(driver)
                .addToCartMultipleBooks(3)
                .closeNitificationSuccess()
                .clickOnShoppingCartLink();
                //.isItemsAdded();




    }
    @Test
    public void addPreferedBookToCart(){
        new BooksPage(driver)
                .selectPreferedBook("Health Book")
                .clickOnAddToCartButtonInsideItemCart()
                .closeNitificationSuccess()
                .clickOnShoppingCartLink()
                .verifyThatHealthBookIsAdded();


    }




}
