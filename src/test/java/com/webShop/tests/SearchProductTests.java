package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.BooksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver)
                .selectBookCategory();
    }

    @Test
    public void searchBook(){
        new BooksPage(driver)
                .searchBookByName("Computing and Internet")
                .clickOnSearchButton()
                .verifyBookByName();
    }






}
