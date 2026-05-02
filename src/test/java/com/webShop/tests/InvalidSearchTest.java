package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.footer.SearchPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidSearchTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).clickOnSearch();
    }

    @Test
    public void searchForNonExistingItem(){
    new SearchPage(driver)
            .fillItemNameIntoSearchKeyWord("alpha")
            .clickOnSearchButton()
            .verifyMessage();


    }
}
