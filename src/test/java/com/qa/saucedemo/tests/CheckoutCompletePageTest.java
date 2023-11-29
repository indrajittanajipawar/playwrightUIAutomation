package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompletePageTest extends BaseTest {

    @Test
    public void clickOnFinishButtonTest(){
        productPage = homePage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        cartPage = productPage.clickAddToCartButtons();
        checkoutYourInformationPage= cartPage.clickOnCheckoutButton();
        checkoutOverviewPage = checkoutYourInformationPage.checkoutOverviewPage(prop.getProperty("firstName").trim(), prop.getProperty("lastName"), prop.getProperty("zipCode"));
        checkoutCompletePage = checkoutOverviewPage.clickOnFinishButton();
    }

    @Test
    public void testGetCompleteHeaderText() {
        String completeHeaderText = checkoutCompletePage.getCompleteHeaderText();

        System.out.println("Complete Header Text: " + completeHeaderText);
        Assert.assertEquals(completeHeaderText, AppConstants.SUCCESSFUL_ORDER_TEXT);

    }

}
