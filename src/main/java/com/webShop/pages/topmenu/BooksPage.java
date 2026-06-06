package com.webShop.pages.topmenu;

import com.webShop.pages.BasePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    WebElement bookName;

    public BooksPage selectBook() {
        click(bookName);

        return this;
    }

    @FindBy(id = "add-to-cart-button-13")
    WebElement addToCartButton;

    public BooksPage clickAddToCartButton() {
        click(addToCartButton);

        return this;
    }

    @FindBy(css = ".cart-label")
    WebElement shoppingCart;

    public ShoppingCartPage clickOnShoppingCartLink() {
        pause(500);
        clickWithJs(shoppingCart, 0, 600);

        return new ShoppingCartPage(driver);
    }

    @FindBy(css = ".item-box .product-box-add-to-cart-button")
    List<WebElement> addButtons;
    @FindBy(css = ".bar-notification.success")
    WebElement successMessage;

    public BooksPage addToCartMultipleBooks(int amount) {
        for (int i = 0; i < amount; i++) {
            WebElement btn = addButtons.get(i);
            btn.click();
            pause(1000);

//            wait.until(ExpectedConditions.visibilityOf(successMessage));
//            wait.until(ExpectedConditions.invisibilityOf(successMessage));
        }
        return this;

    }

    @FindBy(css = "[title='Close']")
    WebElement closeNotification;

    public BooksPage closeNitificationSuccess() {
        wait.until(ExpectedConditions.elementToBeClickable(closeNotification)).click();
        return this;
    }

    @FindBy(css = ".search-box-text.ui-autocomplete-input")
    WebElement searchBox;

    public BooksPage searchBookByName(String text) {
        type(searchBox, text);

        return this;
    }

    @FindBy(css = ".button-1.search-box-button")
    WebElement searchButton;

    public BooksPage clickOnSearchButton() {
        click(searchButton);

        return this;
    }

    @FindBy(tagName = "h2")
    WebElement name;

    public BooksPage verifyBookByName() {
        Assert.assertTrue(shouldHaveText(name, "Computing and Internet", 10));

        return this;

    }

    @FindBy(css = ".product-title")
    List<WebElement> list;

    public boolean checkBookAvailability(String productName) {
        for (WebElement items : list) {
            if (items.getText().equals(productName)) {
                return true;
            }
        }
        return false;

    }

    @FindBy(css = ".product-title")
    List<WebElement> cart;

    public List<String> collectListOfItems() {
        List<String> list = new ArrayList<>();
        for (WebElement items : cart) {
            if (!list.contains(items)) {
                list.add(items.getText());
            }
        }
        return list;


    }

    @FindBy(css = ".product-title")
    List<WebElement> books;
    @FindBy(css = "[src='https://demowebshop.tricentis.com/content/images/thumbs/0000131_health-book_125.jpeg']")
    WebElement book;

    public BooksPage selectPreferedBook(String productName) {
        for (WebElement items : books) {
            if (items.getText().equals(productName)) {
                click(book);
                break;
            }
        }
        return this;
    }

    @FindBy(id = "add-to-cart-button-22")
    WebElement button;

    public BooksPage clickOnAddToCartButtonInsideItemCart() {
        click(button);

        return this;
    }

    @FindBy(css = ".product-title")
    List<WebElement> amountOfBooks;

    public int countItemsOnPage() {
        return amountOfBooks.size();

//        List<String> list = new ArrayList<>();
//
//        for (WebElement elem : amountOfBooks) {
//              list.add(elem.getText());
//        }
//        return list.size();

    }
  }





