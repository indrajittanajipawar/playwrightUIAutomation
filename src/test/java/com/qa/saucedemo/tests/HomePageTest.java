package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test()
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test()
    public void getHomePageURL(){
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL, prop.getProperty("url"));
    }

    @Test()
    public void errorTextMessageTest(){
       String actualErrorMessage = homePage.checkErrorMessage();
       Assert.assertEquals(actualErrorMessage, AppConstants.ERROR_TEXT_MESSAGE);
    }
    @Test
    public void loginPageNavigationTest(){
        homePage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }

}
