package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.registrationlogin.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommunityPollSideBarTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver)
                .selectLoginLink()
                .fillLoginFields("schmidth@gmail.com","schnideR@2")
                .clickOnLoginButton();
    }
    @Test
    public void answerTheCommunityPollSurvey(){
        new HomePage(driver)
                .selectRadioButton()
                .clickOnVoteButton()
                .verifytext();
    }
    @AfterMethod(enabled = false)
    public void logOut(){
        new HomePage(driver)
                .clickOnLogOutButton();

    }




}
