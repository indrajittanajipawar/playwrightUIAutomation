package com.qa.saucedemo.base;

import com.microsoft.playwright.Page;
import com.qa.saucedemo.factory.PlaywrightFactory;
import com.qa.saucedemo.pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    protected Page page;

    protected Properties prop;

    protected  HomePage homePage;
    protected ProductPage productPage;

    protected CheckoutYourInformationPage checkoutYourInformationPage;

    protected  CheckoutOverviewPage checkoutOverviewPage;

    protected CartPage cartPage;

    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeTest
    public void setUp(){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
        checkoutYourInformationPage = new CheckoutYourInformationPage(page);
        checkoutOverviewPage = new CheckoutOverviewPage(page);
        checkoutCompletePage = new CheckoutCompletePage(page);
    }

    @AfterTest
    public  void tearDown(){
        page.context().browser().close();
    }

}
