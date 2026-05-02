package com.webShop.pages.shoppingcart;

import com.webShop.pages.BasePage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country2;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement state;
    @FindBy(id = "BillingNewAddress_City")
    WebElement city1;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCode1;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber1;

    public CheckOutPage fillInBillingAddress(String country1, String city, String address1, String zipCode, String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(country2)).click();
        new Select(country2).selectByVisibleText(country1);

        type(city1, city);
        type(address, address1);
        type(zipCode1, zipCode);
        type(phoneNumber1, phoneNumber);

        return this;
    }

    @FindBy(css = ".button-1.new-address-next-step-button")
    WebElement checkout;

    public CheckOutPage clickOnContinueButtonUnderAddress() {
        click(checkout);
        return this;
    }

    @FindBy(css = "[onclick='Shipping.save()']")
    WebElement continueAddressButton;

    public CheckOutPage selectContinueAtShippingAddress() {
        click(continueAddressButton);
        return this;
    }

    @FindBy(css = ".button-1.shipping-method-next-step-button")
    WebElement continueShipping;
    @FindBy(id = "shippingoption_1")
    WebElement shipping;

    public CheckOutPage selectShippingOption1() {
        click(shipping);
        click(continueShipping);

        return this;
    }

    @FindBy(css = ".button-1.payment-method-next-step-button")
    WebElement paymentContinue;
    @FindBy(id = "paymentmethod_2")
    WebElement paymentMethod;

    public CheckOutPage selectPaymentMethodCreditCard() {
        click(paymentMethod);
        click(paymentContinue);
        return this;
    }

    @FindBy(id = "CreditCardType")
    WebElement creditCardType;
    @FindBy(id = "CardholderName")
    WebElement cardHolder;
    @FindBy(id = "CardNumber")
    WebElement cardNumer;
    @FindBy(id = "ExpireMonth")
    WebElement expDate;
    @FindBy(id = "ExpireYear")
    WebElement experationYear;
    @FindBy(id = "CardCode")
    WebElement cvv;
    @FindBy(css = ".button-1.payment-info-next-step-button")
    WebElement pymentContinue;

    public CheckOutPage enterPaymentInfo(String creditCard, String cardholderName, String cardNumber, String expMonth, String expYear, String cvvCode) {
        wait.until(ExpectedConditions.elementToBeClickable(creditCardType)).click();
        new Select(creditCardType).selectByVisibleText(creditCard);

        type(cardHolder, cardholderName);
        type(cardNumer, cardNumber);

        wait.until(ExpectedConditions.elementToBeClickable(expDate)).click();
        new Select(expDate).selectByVisibleText(expMonth);


        wait.until(ExpectedConditions.elementToBeClickable(experationYear)).click();
        new Select(experationYear).selectByVisibleText(expYear);

        type(cvv, cvvCode);
        click(pymentContinue);
        return this;

    }

    @FindBy(css = ".button-1.confirm-order-next-step-button")
    WebElement confirmButton;

    public CheckOutPage clickOnConfirmButton() {
        click(confirmButton);

        return this;
    }

    @FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
    WebElement text;

    public CheckOutPage verifySuccesfullyProccededCheckOut() {
        Assert.assertTrue(shouldHaveText(text, "Your order has been successfully processed!", 5));
        return this;

    }
}
