package com.qa.saucedemo.tests;

import com.qa.saucedemo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartPageTest extends BaseTest {

    @Test
    public void clickOnCartButtonTest(){
        productPage = homePage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        cartPage = productPage.clickAddToCartButtons();

    }

    @Test
    public void testProductNamesMatch() {



        List<String> actualProductNames = cartPage.getAllProductNames();

        List<String> expectedProductNames = readProductNamesFromFile("C:\\Users\\Mayur\\Desktop\\ij\\Playwright\\src\\test\\resources\\productsdata\\product.txt");

        System.out.println("expected product count :: "+expectedProductNames.size());
        Assert.assertEquals(actualProductNames, expectedProductNames, "Product names do not match!");
    }

    private static List<String> readProductNamesFromFile(String filePath) {
        List<String> productNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                productNames.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productNames;
    }

}
