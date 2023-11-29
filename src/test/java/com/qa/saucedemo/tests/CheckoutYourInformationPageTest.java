package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import org.testng.annotations.Test;

public class CheckoutYourInformationPageTest  extends BaseTest {

    @Test
    public void clickOnContinueButtonTest(){
        productPage = homePage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        cartPage = productPage.clickAddToCartButtons();
        checkoutYourInformationPage= cartPage.clickOnCheckoutButton();
    }

    @Test
    public void enterPersonalInfoTest(){

        checkoutYourInformationPage.checkoutOverviewPage(prop.getProperty("firstName").trim(), prop.getProperty("lastName"), prop.getProperty("zipCode"));

    }
}
