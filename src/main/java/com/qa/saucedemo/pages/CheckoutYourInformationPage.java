package com.qa.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CheckoutYourInformationPage {

    private String fName = "#first-name";
    private String lName = "#last-name";
    private String zCode =  "#postal-code";
    private String continueButton = "#continue";
    Page page;

    CartPage cartPage;

    public CheckoutYourInformationPage(Page page){
        this.page = page;
    }

    public CheckoutOverviewPage checkoutOverviewPage(String firstName, String lastName, String zipCode){

        page.fill(fName, firstName);
        page.fill(lName, lastName);
        page.fill(zCode, zipCode);
        page.click(continueButton);
        page.waitForTimeout(2000);

        return new CheckoutOverviewPage(page);
    }
}
