package com.webShop.pages.cellphone;

import com.webShop.pages.BasePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import com.webShop.pages.topmenu.BooksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.print.DocFlavor;

public class CellPhonePage extends BasePage {

    public CellPhonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".button-2.product-box-add-to-cart-button")
    WebElement addToCart;

    public CellPhonePage addToCartSmartPhone() {
        click(addToCart);

        return this;
    }

    @FindBy(css = ".close")
    WebElement closeNotification;

    public CellPhonePage closeNitificationSuccess() {
        click(closeNotification);

        return this;
    }
    @FindBy(css = ".cart-label")
    WebElement shoppingCart;

    public ShoppingCartPage clickOnShoppingCartLink() {
        click(shoppingCart);

        return new ShoppingCartPage(driver);
    }
}
