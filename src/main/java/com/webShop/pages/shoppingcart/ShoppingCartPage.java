package com.webShop.pages.shoppingcart;

import com.webShop.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.NetworkUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".remove-from-cart input[name='removefromcart']")
    WebElement deleteCheckBox;

    public ShoppingCartPage markCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteCheckBox)).click();

        return this;
    }

    @FindBy(css = ".button-2.update-cart-button")
    WebElement upgradeButton;

    public ShoppingCartPage clickOnUpgradeButton() {
        click(upgradeButton);

        return this;

    }

    @FindBy(css = ".discount-coupon-code")
    WebElement discountCode;

    public ShoppingCartPage applyDiscountCode() {
        type(discountCode, "DISCOUNT123");

        return this;
    }

    @FindBy(id = "CountryId")
    WebElement CountryId;

    public ShoppingCartPage selectCountry(String country) {
        Select select = new Select(CountryId);
        select.selectByVisibleText(country);
        return this;
    }

    @FindBy(id = "StateProvinceId")
    WebElement StateProvinceId;
    public ShoppingCartPage selectStateProvince(String state) {
        wait.until(ExpectedConditions.textToBePresentInElement(StateProvinceId,state));
        Select select = new Select(StateProvinceId);
        select.selectByVisibleText(state);
        return this;
    }

    @FindBy(id = "termsofservice")
    WebElement termsofservice;

    public ShoppingCartPage markCheckBoxAtCheckOut() {
        click(termsofservice);

        return this;
    }

    @FindBy(css = "[name='removefromcart']")
    WebElement checkBox;

    public ShoppingCartPage selectChecbox() {
        click(checkBox);

        return this;
    }

    @FindBy(css = "[name='updatecart']")
    WebElement updateShoppingCart;

    public ShoppingCartPage clickOnUpdateButton() {
        click(updateShoppingCart);

        return this;
    }

    @FindBy(xpath = "//h1[text()='Shopping cart']")
    WebElement emptyCart;

    public ShoppingCartPage verifyThatItemDeleted() {
        click(emptyCart);

        return this;
    }

    @FindBy(css = ".product-name")
    WebElement item;

    public ShoppingCartPage verifyThatCardAddedToShoppingCart() {
        Assert.assertTrue(shouldHaveText(item, "$100 Physical Gift Card", 5));

        return this;
    }

    @FindBy(css = ".inputs select#StateProvinceId")
    WebElement StateProvinceId1;


    public ShoppingCartPage selectProvince(String state) {
        wait.until(ExpectedConditions.visibilityOf(StateProvinceId1));

        Select select = new Select(StateProvinceId1);
        select.selectByVisibleText(state);
        return this;
    }

    @FindBy(id = "CountryId")
    WebElement CountryId1;

    public ShoppingCartPage selectCountrys(String country) {
        Select select = new Select(CountryId1);
        select.selectByVisibleText(country);
        return this;
    }

    @FindBy(id = "termsofservice")
    WebElement termsofservice1;

    public ShoppingCartPage markTermsAndConditionsCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(termsofservice1)).click();
        return this;
    }

    @FindBy(id = "checkout")
    WebElement checkOutButton;

    public CheckOutPage clickOnCheckOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();

        return new CheckOutPage(driver);
    }

    @FindBy(css = ".product-name")
    WebElement text;

    public ShoppingCartPage verifyThatHealthBookIsAdded() {
        Assert.assertTrue(isElementDisplayed(text));
        return this;
    }

    @FindBy(css = ".product-name")
    List<WebElement> list;

    public boolean checkThatItemIsPresent(String productName) {
        for (WebElement elem : list) {
            if (elem.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

//    @FindBy(css = ".details h2 ")
//    List<WebElement> titleList;
//    @FindBy(css = ".price")
//    List<WebElement> priceList;

    @FindBy(css = ".cart-item-row")
    List<WebElement> rows;

    public String getProductPrice(String productName) {
        for (WebElement elem : rows) {
            String title = elem.findElement(By.cssSelector(".product-name")).getText();
            if (title.equals(productName)) {
                return elem.findElement(By.cssSelector(".product-unit-price")).getText();
            }
        }
        return null;
    }

    @FindBy(css = ".cart-item-row")
    List<WebElement> cartRows;

    public ShoppingCartPage findProductByName(String productName) {
        for (WebElement row : cartRows) {
            String currentName = row.findElement(By.cssSelector(".product-name")).getText();
            if (currentName.equals(productName)) {
                WebElement removeCheckBox = row.findElement(By.cssSelector(".remove-from-cart input[name='removefromcart']"));
                click(removeCheckBox);
            }
        }
        return this;

    }

    public int getProductQuantity(String productName) {
        for (WebElement row : cartRows) {
            String product = row.findElement(By.cssSelector(".product-name")).getText();
            if (product.trim().equals(productName)) {
                WebElement quantityBox = row.findElement(By.cssSelector("input.qty-input"));
                String attribute = quantityBox.getAttribute("value");
                int num = Integer.parseInt(attribute);
                return num;
            }
        }
        return 0;
    }

    @FindBy(css = ".cart-item-row")
    List<WebElement> itemsList;

    public boolean isProductWithCorrectPrice(String productName, String expectedPrice) {
        for (WebElement item : itemsList) {
            WebElement title = item.findElement(By.className("product-name"));
            WebElement price = item.findElement(By.className("product-unit-price"));
            if (title.getText().equals(productName) && price.getText().equals(expectedPrice)) {
                return true;

            }

        }
        return false;
    }

    public List<String> getAllProductsInCart() {
        List<String> list = new ArrayList<>();
        for(WebElement product: itemsList){
            if(!list.contains(product)){
                list.add(product.getText());
            }
        }
        return list;

    }
    public boolean isCartNotEmpty() {
            if(itemsList.size() > 0){
                return true;

        }
            return false;

    }

    public ShoppingCartPage updateProductQuantity(String productName, int newQuantity) {
        for(WebElement item: itemsList){
            WebElement title = item.findElement(By.cssSelector("td.product .product-name"));
            WebElement quantityBox = item.findElement(By.cssSelector(".cart-item-row input.qty-input"));
            if(title.getText().equals(productName)){
                click(quantityBox);
                quantityBox.clear();
                quantityBox.sendKeys(String.valueOf(newQuantity));
                click(updateShoppingCart);
                break;

            }
        }
        return this;
    }
    public boolean isTotalUpdated(String productName, String oldTotal){
        for(WebElement item: itemsList){
            WebElement title = item.findElement(By.className("product-name"));
            WebElement quantityBox = item.findElement(By.cssSelector("input.qty-input"));
            if(title.getText().equals(productName) && !quantityBox.getAttribute("value").equals(oldTotal)){
                return true;
            }
        }
        return false;

    }
    @FindBy(css = ".product-name")
    WebElement title;
    public ShoppingCartPage verifyThatItemAddedSuccesfully() {
        shouldHaveText(title,"3rd Album",5);
        return this;
    }
//    @FindBy()
//    public ShoppingCartPage verifyThatItemAddedSuccesfully() {
//    }
}









