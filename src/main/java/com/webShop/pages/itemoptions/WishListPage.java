package com.webShop.pages.itemoptions;

import com.webShop.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[src='https://demowebshop.tricentis.com/content/images/thumbs/0000116_blue-and-green-sneaker_80.jpeg']")
    WebElement sneaker;
    public WishListPage verifyItemSneakers() {
        Assert.assertTrue(isElementDisplayed(sneaker));
        return this;
    }
}
