package com.qa.saucedemo.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    private String loginButton = "#login-button";
    private String errorText = "Epic sadface: Username is requ";
    private String userName = "#user-name";
    private String password = "#password";

    public HomePage(Page page){
        this.page = page;
    }

    public String getHomePageTitle(){
        String title =  page.title();
        System.out.println("Page title is :: "+title);
        return title;
    }

    public String getHomePageURL(){
        String pageURL =  page.url();
        System.out.println("Page URL is :: "+pageURL);
        return pageURL;
    }

    public String checkErrorMessage(){

        page.click(loginButton);
        String errorTextMessage =  page.locator("[data-test=\"error\"]").textContent();
        System.out.println("Error text is :: "+errorTextMessage);

        return errorTextMessage;
    }

    public ProductPage doLogin(String appUserName, String appPassword){
        System.out.println("App cred: "+appUserName+" : "+appPassword);
        page.fill(userName, appUserName);
        page.fill(password, appPassword);
        page.click(loginButton);

        return new ProductPage(page);
    }
}
