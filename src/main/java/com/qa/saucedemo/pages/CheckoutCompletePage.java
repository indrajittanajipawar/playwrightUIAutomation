package com.qa.saucedemo.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class CheckoutCompletePage {

    private String backButton = ".btn.btn_primary.btn_small";
    Page page;

    public CheckoutCompletePage(Page page){
        this.page = page;
    }

    public String getCompleteHeaderText() {
        String cssSelector = ".complete-header";
        ElementHandle h2Element = page.querySelector(cssSelector);

        if (h2Element != null) {
            return h2Element.innerText();
        } else {
            return "Element not found.";
        }
    }

}
