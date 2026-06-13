package com.webShop.pages.topmenu;

import com.webShop.pages.BasePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DigitalDownloadsPage extends BasePage {

    public DigitalDownloadsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".item-box")
    List<WebElement> downloadsList;
    public DigitalDownloadsPage selectAnyDownload(String name) {
        for(WebElement element: downloadsList ){
                WebElement title = element.findElement(By.cssSelector(".product-title"));
                WebElement picture = element.findElement(By.cssSelector("h2"));
                if(title.getText().equals(name) ){
                    click(picture);
                    return this;
            }
        }
     return null;
    }
   @FindBy(id = "addtocart_53_EnteredQuantity")
   WebElement quantityBox;
    public DigitalDownloadsPage indicateQuantity(String quantity) {
        type(quantityBox,quantity);
        return this;
    }
    @FindBy(id = "add-to-cart-button-53")
    WebElement addButton;
    public DigitalDownloadsPage addToCart() {
        addButton.click();
        return this;
    }
    @FindBy(css = ".close")
    WebElement close;
    public DigitalDownloadsPage clickOnSuccessBarNotification() {
       wait.until(ExpectedConditions.elementToBeClickable(close)).click();
        return this;
    }

    @FindBy(css = ".cart-label")
    WebElement shoppingCart;
    public ShoppingCartPage openShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart)).click();
        return new ShoppingCartPage(driver);
    }


}
