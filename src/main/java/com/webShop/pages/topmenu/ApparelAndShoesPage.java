package com.webShop.pages.topmenu;

import com.webShop.pages.BasePage;
import com.webShop.pages.itemoptions.WishListPage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApparelAndShoesPage extends BasePage {


    public ApparelAndShoesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[src='https://demowebshop.tricentis.com/content/images/thumbs/0000116_blue-and-green-sneaker_125.jpeg']")
    WebElement picture;
    public ApparelAndShoesPage selectSneakers() {
       wait.until(ExpectedConditions.elementToBeClickable(picture)).click();
        return this;
    }

    @FindBy(css = "[style='background-color:#000000;']")
    WebElement black;
    public ApparelAndShoesPage selectColorBlack() {
        click(black);

        return this;
    }

    @FindBy(css = ".button-1.add-to-cart-button")
    WebElement addToCartButton;

    public ApparelAndShoesPage clickOnAddToCartB() {
        click(addToCartButton);

        return this;
    }
    @FindBy(css = ".close")
    WebElement closeNotification;
    public  ApparelAndShoesPage closeGreenMassegeBar() {
       wait.until(ExpectedConditions.elementToBeClickable(closeNotification)).click();
      return this;
    }
    @FindBy(css = ".cart-label")
    WebElement shoppingCart;

    public ShoppingCartPage selectShoppingCartLink() {
        pause(500);
        clickWithJs(shoppingCart,0,600);

        return new ShoppingCartPage(driver);
    }

    @FindBy(id = "add-to-wishlist-button-28")
    WebElement wishList;

    public ApparelAndShoesPage clickOnAddToWishListButton() {
        click(wishList);

        return this;


    }
    @FindBy(css = ".close")
    WebElement close;

    public ApparelAndShoesPage clickOnSuccessBarNotification() {
        wait.until(ExpectedConditions.elementToBeClickable(close)).click();
        return this;
    }
    @FindBy(css = ".ico-wishlist")
    WebElement wishListLink;
    public WishListPage clickOnWishlist() {
     click(wishListLink);

        return new WishListPage(driver);
    }
}
