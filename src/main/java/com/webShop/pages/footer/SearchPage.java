package com.webShop.pages.footer;

import com.webShop.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Q")
    WebElement keyWord;
    public  SearchPage fillItemNameIntoSearchKeyWord(String item) {
        wait.until(ExpectedConditions.visibilityOf(keyWord)).sendKeys(item);
        return this;
    }
    @FindBy(id = "As")
    WebElement checkBox;
    public SearchPage markAdvanceCheckBox() {
        click(checkBox);
        return this;
    }
    @FindBy(id = "Cid")
    WebElement category;
    public SearchPage selectCategoryInDropDownList(String categoryName) {
        Select select = new Select(category);
        select.selectByVisibleText(categoryName);
        return this;
    }
    @FindBy(id = "Pf")
    WebElement from;
    @FindBy(id = "Pt")
    WebElement to;
    public SearchPage indicatePriceRange() {
        type(from,"9");
        type(to,"100");

        return this;
    }
    @FindBy(id = "Sid")
    WebElement searchProductCheckbox;
    public SearchPage markSearchInProductDescription() {
        click(searchProductCheckbox);
        return this;
    }
    @FindBy(css = ".button-1.search-button")
    WebElement searchButton;
    public SearchPage clickOnSearchButton() {
        click(searchButton);
        return this;
    }
    @FindBy(xpath = "//a[text()='Health Book']")
    WebElement book;
    public SearchPage verifyThatBookDisplayed() {
        Assert.assertTrue(shouldHaveText(book,"Health Book",5));
        return this;
    }
   @FindBy(css = ".result")
   WebElement message;
    public SearchPage verifyMessage() {
        Assert.assertTrue(isElementDisplayed(message));
        return this;
    }
}
