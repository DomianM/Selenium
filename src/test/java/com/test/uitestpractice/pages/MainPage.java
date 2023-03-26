package com.test.uitestpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='countriesSingle']")
    List<WebElement> allList;
    public void validateDefaultIndia(String country){

        List<String>expectedList= Arrays.asList();
        for(int i=0;i<allList.size();i++){
            Assert.assertEquals(BrowserUtils.getText (allList.get(i)),expectedList.get(i));
        }
    }

}
