package com.qa.saucedemo.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private String checkOutButton = "#checkout";
    Page page;
    ProductPage productPage;

    public CartPage(Page page){
        this.page = page;
    }

    public List<String> getAllProductNames() {
        List<String> productNames = new ArrayList<>();

        List<ElementHandle> elements = page.locator(".inventory_item_name").elementHandles();
        System.out.println("count of the products :: "+elements.size());

        for (ElementHandle element : elements) {
            productNames.add(element.innerText());
            System.out.println(element.innerText());
        }

        return productNames;
    }

    public CheckoutYourInformationPage clickOnCheckoutButton(){

        page.click(checkOutButton);
        page.waitForTimeout(2000);

        return new CheckoutYourInformationPage(page);
    }

}
