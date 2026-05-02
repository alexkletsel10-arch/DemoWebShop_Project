package com.webShop.pages.footer;

import com.webShop.pages.BasePage;
import com.webShop.pages.HomePage;
import com.webShop.pages.shoppingcart.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class EditAddressPage extends BasePage {
    public EditAddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[type='button']")
    List<WebElement> edit1;
    public EditAddressPage clickOnEditButton() {
       edit1.get(0).click();
        return this;
    }
    @FindBy(id = "Address_CountryId")
    WebElement editCountry;
    public EditAddressPage selectCountry(String country) {
        Select select = new Select(editCountry);
        select.selectByVisibleText(country);
        return this;
    }
    @FindBy(css = "[data-val-required='City is required']")
    WebElement editCity;
    public EditAddressPage enterCity(String city) {
       type(editCity,city);
        return this;
    }
    @FindBy(id = "Address_Address1")
    WebElement editAddress;
    public EditAddressPage enterAddress(String address) {
        type(editAddress,address);
        return this;

    }
    @FindBy(id = "Address_ZipPostalCode")
    WebElement editZipCode;
    public EditAddressPage enterZipCode(String zipCode) {
        type(editZipCode,zipCode);
        return this;
    }
    @FindBy(id = "Address_PhoneNumber")
    WebElement editPhone;
    public EditAddressPage enterPhoneNumber(String phoneNumber) {
        type(editPhone,phoneNumber);
        return this;
    }
    @FindBy(css = ".button-1.save-address-button")
    WebElement save;
    public EditAddressPage clickOnSaveButton() {
        click(save);
        return this;
    }
    @FindBy(tagName = "h1")
    WebElement title;
    public EditAddressPage verifyTitle() {
        Assert.assertTrue(isElementDisplayed(title));
        return this;
    }
}
