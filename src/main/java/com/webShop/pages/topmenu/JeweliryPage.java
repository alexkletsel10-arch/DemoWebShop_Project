package com.webShop.pages.topmenu;

import com.webShop.pages.BasePage;
import com.webShop.pages.email.EmailFriendPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class JeweliryPage extends BasePage {
    public JeweliryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[alt='Picture of Create Your Own Jewelry']")
    WebElement chain;

    public JeweliryPage  selectChain() {
        click(chain);
        return this;
    }
    @FindBy(id = "product_attribute_71_9_15")
    WebElement metal;

    public JeweliryPage selectMaterial(String material) {
        Select select = new Select(metal);
        select.selectByVisibleText(material);

        return this;



    }
    @FindBy(css = ".textbox")
    WebElement length;

    public JeweliryPage enterLenght() {
        type(length,"25");

        return this;

    }

    @FindBy(id = "product_attribute_71_11_17_49")
    WebElement heart;

    public JeweliryPage selectPedantRadioButton() {
        click(heart);

        return this;
    }
    @FindBy(css = ".button-2.email-a-friend-button")
    WebElement emailButton;

    public EmailFriendPage clickOnEmailFriendButton() {
        click(emailButton);

        return new EmailFriendPage(driver);
    }
}
