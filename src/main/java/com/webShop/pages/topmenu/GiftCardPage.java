package com.webShop.pages.topmenu;

import com.webShop.pages.BasePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GiftCardPage extends BasePage {
    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[alt='Picture of $100 Physical Gift Card']")
    WebElement hundredDollarsGiftCard;

    public GiftCardPage selectGiftCardWithAmount() {
        wait.until(ExpectedConditions.elementToBeClickable(hundredDollarsGiftCard))
                .click();

        return this;
    }

    @FindBy(css = ".recipient-name")
    WebElement recipient;

    public GiftCardPage fillInYourName() {
        wait.until(ExpectedConditions.visibilityOf(recipient))
                .sendKeys("Dominic");

        return this;
    }
    @FindBy(css = ".sender-name")
    WebElement sender;

    public GiftCardPage fillInRecipientsName() {
        wait.until(ExpectedConditions.visibilityOf(sender))
                .sendKeys("jimmy");

        return this;
    }

    @FindBy(css = ".message")
    WebElement massageToFriend;

    public GiftCardPage fillInMassageField() {
        wait.until(ExpectedConditions.visibilityOf(massageToFriend))
                .sendKeys("Good luck mother fucker");

        return this;
    }
    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCart;

    public GiftCardPage clickOnAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart))
                .click();
        return this;
    }

    @FindBy(css = ".cart-label")
    WebElement shoppingCart;

    public ShoppingCartPage openOnShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart))
                .click();
        return new ShoppingCartPage(driver);
    }

    @FindBy(css = ".close")
    WebElement closeNotification;

    public GiftCardPage closeGreenMassegeBar() {
        wait.until(ExpectedConditions.elementToBeClickable(closeNotification))
                .click();

        return this;
    }
}

