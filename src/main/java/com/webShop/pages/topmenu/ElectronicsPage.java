package com.webShop.pages.topmenu;

import com.webShop.pages.BasePage;
import com.webShop.pages.camera.CameraPage;
import com.webShop.pages.cellphone.CellPhonePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElectronicsPage extends BasePage {

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[alt='Picture for category Cell phones']")
    WebElement cellPhone;

    public CellPhonePage selectCellPhones() {
        click(cellPhone);

        return new CellPhonePage(driver);

    }
    @FindBy(css = "[alt='Picture for category Camera, photo']")
    WebElement slrCamera;

    public CameraPage selectCamera() {
        wait.until(ExpectedConditions.elementToBeClickable(slrCamera)).click();

        return new CameraPage(driver);
    }
}
