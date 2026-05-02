package com.webShop.tests;

import com.webShop.pages.HomePage;
import com.webShop.pages.topmenu.JeweliryPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailToFriend extends TestBase{

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver)
                .selectLoginLink()
                .fillLoginFields("schmidth@gmail.com","schnideR@2")
                .clickOnLoginButton()
                .clickOnJewelryLink();
    }
    @Test
    public void sendEmailToFriend(){
         new JeweliryPage(driver)
                .selectChain()
                .selectMaterial("Gold (0,5 mm)")
                .enterLenght()
                .selectPedantRadioButton()
                .clickOnEmailFriendButton()
                .enterFriendsEmail()
                .clickOnSendEmailButton()
                 .verifySuccessMessage();

    }
}
