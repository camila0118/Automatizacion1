package com.co.outline.pages;


import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {


    org.openqa.selenium.By TXT_USERNAME = By.xpath("//input[@id='user-name']");
    org.openqa.selenium.By TXT_PASSWORD = By.xpath("//input[@id='password']");
    org.openqa.selenium.By BTN_LOGIN = By.xpath("//input[@id='login-button']");


    public org.openqa.selenium.By getTXT_USERNAME() {
        return TXT_USERNAME;
    }

    public org.openqa.selenium.By getTXT_PASSWORD() {
        return TXT_PASSWORD;
    }

    public org.openqa.selenium.By getBTN_LOGIN() {
        return BTN_LOGIN;
    }


}
