package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ShoppingCartTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver)
                .clickOnBooksLinkAtTopMenu()
                .addToCartMultipleBooks(3)
                .closeNitificationSuccess()
                .clickOnShoppingCartLink();

    }
    @Test
    public void findProperItem(){
        boolean result =  new ShoppingCartPage(driver)
                .checkThatItemIsPresent("Fiction");
        Assert.assertTrue(result);

    }
    @Test
    public void searchForProductPrice() {
        String actualPrice = new ShoppingCartPage(driver)
                .getProductPrice ("Fiction");
        Assert.assertEquals(actualPrice,"24.00");



    }
    @Test
    public void checkIfItemPresentInShoppingCart(){
       boolean res = new ShoppingCartPage(driver)
               .isProductWithCorrectPrice("Computing and Internet","10.00");
       Assert.assertTrue(res);
    }
    @Test
    public void getListOfItems(){
        List<String> result = new ShoppingCartPage(driver)
                .getAllProductsInCart();

    }
    @Test
    public void verifyIfCartIsNotEmpty(){
        boolean res = new ShoppingCartPage(driver)
                .isCartNotEmpty();
        Assert.assertTrue(res);
    }
    @Test
    public void updateQuantity(){
        new ShoppingCartPage(driver)
                .updateProductQuantity("Fiction",5)
                .isTotalUpdated("Fiction","1");

    }

    }



