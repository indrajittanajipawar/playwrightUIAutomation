package com.qa.saucedemo.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.List;

public class CheckoutOverviewPage {

    private String finishButton  = "#finish";
    Page page;
    public CheckoutOverviewPage(Page page){
        this.page = page;
    }

    public double calculateTotalCost() {
        double totalPrice = 0.0;
        List<ElementHandle> priceElements = page.querySelectorAll(".inventory_item_price");

        for (ElementHandle priceElement : priceElements) {
            String priceText = priceElement.innerText();

            double priceValue = Double.parseDouble(priceText.replaceAll("[^\\d.]+", ""));

            totalPrice += priceValue;
        }

        return totalPrice;
    }

    public CheckoutCompletePage clickOnFinishButton(){

        page.click(finishButton);
        page.waitForTimeout(2000);

        return new CheckoutCompletePage(page);
    }
}
