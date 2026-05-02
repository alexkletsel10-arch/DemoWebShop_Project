package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Arrays;

public class TestBase {
    WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

    }


    @BeforeMethod
    public void startTest(Method method, Object[]p){
        logger.info("Start test" + method.getName() + Arrays.asList(p));
    }
    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED" + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED" + result.getMethod().getMethodName() + "Screenshot path: " + takeScreenShot() );
        }
        logger.info("Stop test");
        logger.info("********************************************************");

    }

public String takeScreenShot() {
    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");


    try {
        screenshot.getParentFile().mkdirs();
        Files.copy(tmp.toPath(), screenshot.toPath());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return screenshot.getAbsolutePath();

 }
    @AfterMethod()
    public void stop(){
        driver.quit();



    }
}

