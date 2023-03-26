package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {


/*
1-Navigate to the website "https://www.demoblaze.com/#"
2-Click the Laptops from homepage(firstPage)
3-Click MacBook Pro from the list with Loop(LaptopPage)
4-Click Add to cart button
5-Validate the text and click ok button(you already have method)
6-Click Cart Button top(WebElement can be in MainPage)
7-Validate the Name of Product and Price(no need test class for it just method)
8-Click Place Order and provide all the information(ORDER PAGE)
9-Validate the Thank you message and click OK
10-Validate the url is "https://www.demoblaze.com/index.html"

 */


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }


    @FindBy(tagName = "td")
    List<WebElement> allInformation;


    public void validateProductInformation(String title, String price){
        List<String>expectedInformation = Arrays.asList("",title,price,"");
        for(int i =0;i<allInformation.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));

        }
    }
    //picture, title, price, delete --->4
    ///"", title, price,"" --->4 we need to have the same amount
}
