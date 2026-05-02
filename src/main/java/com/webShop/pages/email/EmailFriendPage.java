package com.webShop.pages.email;

import com.webShop.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class EmailFriendPage extends BasePage {
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendsEmail;
    
    public EmailFriendPage enterFriendsEmail() {
        type(friendsEmail, "anaconda14@gmail.com");
        return this;

    }

    @FindBy(css = ".button-1.send-email-a-friend-button")
    WebElement button;

    public EmailFriendPage clickOnSendEmailButton() {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        return this;

    }
    @FindBy(css = ".result")
    WebElement result;

    public EmailFriendPage verifySuccessMessage() {
        Assert.assertTrue(isElementDisplayed(result));

        return this;
    }

}
