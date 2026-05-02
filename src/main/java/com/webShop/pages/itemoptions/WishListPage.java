package com.webShop.pages.itemoptions;

import com.webShop.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Blue and green Sneaker']")
    WebElement sneaker;

    public WishListPage verifyItemSneakers(String name) {
        Assert.assertTrue(shouldHaveText(sneaker,"Blue and green Sneaker",5));

        return this;



    }
}
