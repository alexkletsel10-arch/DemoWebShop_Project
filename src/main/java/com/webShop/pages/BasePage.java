package com.webShop.pages;

import com.webShop.pages.topmenu.ApparelAndShoesPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;
    public static JavascriptExecutor js;
    public WebDriverWait wait;
    public Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        logger.info("Test statrt in Chrome browser");
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }

    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException exception) {
            exception.getMessage();
            return false;
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWithJs(WebElement element, int x, int y) {

        //JavascriptExecutor js = (JavascriptExecutor)driver;
        moveWithJs(x, y);
        click(element);
    }

    public void moveWithJs(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public static void typeReplace(WebElement elem, String text) {
        elem.click();
        elem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elem.sendKeys(Keys.DELETE);
        elem.sendKeys(text);
        elem.sendKeys(Keys.ENTER);

    }

    public boolean isItemAdded(String text) {
        List<WebElement> items = driver.findElements(By.cssSelector("H2"));
        for (WebElement element : items) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }
}








