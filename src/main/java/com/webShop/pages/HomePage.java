package com.webShop.pages;
import java.util.List;
import com.webShop.pages.camera.CameraPage;
import com.webShop.pages.footer.EditAddressPage;
import com.webShop.pages.footer.SearchPage;
import com.webShop.pages.registrationlogin.LoginPage;
import com.webShop.pages.registrationlogin.RegistrationPage;
import com.webShop.pages.topmenu.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "[href='/register']")
    WebElement regLink;

    public RegistrationPage selectRegistrationLink() {
        click(regLink);
        return new RegistrationPage(driver);

    }

    @FindBy(xpath = "//a[text()='Log out']")
    WebElement logoutLink;

    public HomePage verifyLogOutLinkIsPresent() {
        Assert.assertTrue(shouldHaveText(logout,"Log out",5));
        return this;
    }

    @FindBy(css = ".header a[href='/login']")
    WebElement loginLink;

    public LoginPage selectLoginLink() {
      wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();

        return new LoginPage(driver);
    }

    @FindBy(css = ".top-menu li a[href='/books']")
    WebElement booksLink;

    public BooksPage clickOnBooksLink() {
        click(booksLink);

        return new BooksPage(driver);
    }

    @FindBy(css = "[href='/apparel-shoes']")
    WebElement apparelLink;

    public ApparelAndShoesPage selectApparelAndShoes() {
        click(apparelLink);

        return new ApparelAndShoesPage(driver);

    }

    @FindBy(id = "pollanswers-1")
    WebElement answer1;

    public HomePage selectRadioButton() {
        pause(1000);
        click(answer1);

        return this;
    }

    @FindBy(id = "vote-poll-1")
    WebElement voteButton;

    public HomePage clickOnVoteButton() {
        click(voteButton);

        return this;
    }

    @FindBy(css = ".ico-logout")
    WebElement logout;

    public HomePage clickOnLogOutButton() {
        click(logout);

        return this;
    }

    @FindBy(css = ".poll-results li.answer:first-child")
    WebElement exelent;

    public HomePage verifytext() {
        Assert.assertTrue(shouldHaveText(exelent, "Excellent", 5));

        return this;
    }

    @FindBy(css = ".top-menu li a[href='/books']")
    WebElement booksPage;

    public BooksPage selectBookCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(booksPage)).click();
        return new BooksPage(driver);

    }

    @FindBy(css = "[href='/jewelry']")
    WebElement jewelryLink;

    public JeweliryPage clickOnJewelryLink() {
        click(jewelryLink);

        return new JeweliryPage(driver);

    }

    @FindBy(css = "ul.top-menu a[href='/electronics']")
    WebElement smartPhone;

    public ElectronicsPage selectElectronics() {
       wait.until(ExpectedConditions.elementToBeClickable(smartPhone)).click();

        return new ElectronicsPage(driver);
    }

    @FindBy(css = "[href='/gift-cards']")
    WebElement giftCard;

    public GiftCardPage selectGiftCards() {
        wait.until(ExpectedConditions.elementToBeClickable(giftCard)).click();

        return new GiftCardPage(driver);

    }

    @FindBy(css = "[href='/search']")
    WebElement searchLink;
    public SearchPage clickOnSearch() {
        click(searchLink);
        return  new SearchPage(driver);
    }
    @FindBy(xpath = "//a[text()='Addresses']")
    WebElement adressLink;
    public EditAddressPage clickOnAddressLink() {
        wait.until(ExpectedConditions.elementToBeClickable(adressLink)).click();
        return new EditAddressPage(driver);

    }

    public BooksPage clickOnBooksLinkAtTopMenu() {
        click(booksLink);

        return new BooksPage(driver);
    }
    @FindBy(css = "ul.top-menu a[href='/digital-downloads']")
    WebElement digitalLink;
    public DigitalDownloadsPage selectDigitalDownloads() {
        click(digitalLink);
        return new DigitalDownloadsPage(driver);

    }
    @FindBy(css = ".ico-logout")
    WebElement logoutButton;
    public HomePage clickOnLogOutLinkIfPresent() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return this;
    }
    @FindBy(css = ".header a[href='/login']")
    List<WebElement> loginLinks;

    @FindBy(css = ".header a[href='/logout']")
    List<WebElement> logoutLinks;
    public boolean isLoginLinkPresent() {
        return loginLinks.size() > 0;
    }

    public boolean isLogoutLinkPresent() {
        return logoutLinks.size() > 0;
    }

    public HomePage clickLogOutLinkIfPresent() {
        if (isLogoutLinkPresent()) {
            logoutLinks.get(0).click();
        }
        return this;
    }

}




