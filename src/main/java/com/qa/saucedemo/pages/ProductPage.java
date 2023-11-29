package com.qa.saucedemo.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    private String shoppingCartButton = ".shopping_cart_link";
    private String buttonSelector = ".btn.btn_primary.btn_small.btn_inventory";

    private Page page;
    private HomePage homePage;

    public ProductPage(Page page){
        this.page = page;
    }

    public String getProductPageTitle(){
        return page.title();
    }

    public List<String> getAllElementText(String cssSelector) {
        List<ElementHandle> elements = page.querySelectorAll(cssSelector);
        List<String> elementTexts = new ArrayList<>();

        for (ElementHandle element : elements) {
            String text = element.innerText();
            elementTexts.add(text);
        }

        return elementTexts;
    }

    public CartPage clickAddToCartButtons() {
        List<ElementHandle> buttons = page.querySelectorAll(buttonSelector);
        for (ElementHandle button : buttons) {
            button.click();
            int numberOfProductsAddCartButtons = buttons.size();
            System.out.println("Number of button present :: "+numberOfProductsAddCartButtons);
            page.waitForTimeout(2000);
        }
        page.waitForSelector("a:has-text('6')", new Page.WaitForSelectorOptions().setTimeout(5000));
        page.click("a:has-text('6')");
        return new CartPage(page);
    }

}
