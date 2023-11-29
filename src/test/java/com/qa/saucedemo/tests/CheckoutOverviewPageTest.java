package com.qa.saucedemo.tests;

import com.microsoft.playwright.ElementHandle;
import com.qa.saucedemo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test
    public void clickOnContinueButtonTest(){
        productPage = homePage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        cartPage = productPage.clickAddToCartButtons();
        checkoutYourInformationPage= cartPage.clickOnCheckoutButton();
        checkoutOverviewPage = checkoutYourInformationPage.checkoutOverviewPage(prop.getProperty("firstName").trim(), prop.getProperty("lastName"), prop.getProperty("zipCode"));

    }

    @Test
    public void testCalculateTotalCost() {

        double calculatedTotal = checkoutOverviewPage.calculateTotalCost();

        System.out.println("calculatedTotal  :: "+calculatedTotal);
        ElementHandle totalAmountElement = page.querySelector(".summary_subtotal_label");

        String totalAmountText = totalAmountElement.innerText();

        double actualTotalAmount = Double.parseDouble(totalAmountText.replaceAll("[^\\d.]+", ""));
        System.out.println("actualTotalAmount  ::  "+actualTotalAmount);

        Assert.assertEquals(calculatedTotal, actualTotalAmount, "Total cost does not match the expected total amount");
    }
}
