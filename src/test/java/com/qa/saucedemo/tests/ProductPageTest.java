package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductPageTest extends BaseTest {


    @Test
    public void loginPageNavigationTest(){
       productPage = homePage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

    }

    @Test
    public void testProductPageTitle(){
        String actualProductPageTitle = productPage.getProductPageTitle();
        System.out.println("Product Page title is :: "+actualProductPageTitle);
        Assert.assertEquals(actualProductPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void testGetTextAndStoreInFile() {
        String cssSelector = ".inventory_item_name ";
        String filePath = "C:\\Users\\Mayur\\Desktop\\ij\\Playwright\\src\\test\\resources\\productsdata\\product.txt";

        List<String> elementTexts = productPage.getAllElementText(cssSelector);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String text : elementTexts) {
                writer.write(text);
                writer.newLine();
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClickAddToCartButtons() {
        int timeoutMillis = 2000;
        productPage.clickAddToCartButtons();
    }
}
