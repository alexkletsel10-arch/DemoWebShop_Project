package com.webShop.pages.camera;

import com.webShop.pages.BasePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import com.webShop.pages.topmenu.ElectronicsPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CameraPage extends BasePage {
    public CameraPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[alt='Picture of Digital SLR Camera 12.2 Mpixel']")
    WebElement camerSLR;

    public CameraPage clickOnSLRCamera() {
        wait.until(ExpectedConditions.elementToBeClickable(camerSLR)).click();

        return this;
    }
   @FindBy(id = "addtocart_18_EnteredQuantity")
    WebElement quantityBox;

    public CameraPage increaseQuantity() {
        type(quantityBox,"8");

        return this;
    }

    @FindBy(id = "add-to-cart-button-18")
    WebElement addButton;

    public CameraPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

        return this;

    }
    @FindBy(css = ".close")
    WebElement x;

    public CameraPage closeGreenSuccesBar() {
        wait.until(ExpectedConditions.elementToBeClickable(x)).click();

        return this;
    }

    @FindBy(css = "[href='/cart']")
    WebElement cart;

    public ShoppingCartPage openShoppingCart() {
        moveWithJs(800,0);
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();

        return new ShoppingCartPage(driver);
    }
}

