package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.footer.SearchPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchInFooterTest extends TestBase {
    @BeforeMethod
    public void selectSearchInCustomerService(){
        new HomePage(driver).clickOnSearch();

    }
    @Test
    public void searchForAnItem(){
        new SearchPage(driver)
                .fillItemNameIntoSearchKeyWord("health")
                .markAdvanceCheckBox()
                .selectCategoryInDropDownList("Books")
                .indicatePriceRange()
                .markSearchInProductDescription()
                .clickOnSearchButton()
                .verifyThatBookDisplayed();
    }
    



}
