package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.BooksPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class CheckIfProductPresent extends TestBase{
    @BeforeMethod
    public void preconditions(){
        new HomePage(driver)
                .selectBookCategory();
    }
    @Test
    public void checkThatCertainBookIsPresent(){
        new BooksPage(driver)
                .checkBookAvailability("Science");
    }
    @Test
    public void getListOfItems(){
        new BooksPage(driver)
                .collectListOfItems();

    }
    @Test
    public void findOutAmountOfItemsOnPage(){
        new BooksPage(driver)
                .countItemsOnPage();
    }
}
