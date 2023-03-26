package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SellPage {
    public SellPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



}
