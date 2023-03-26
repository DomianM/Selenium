package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageBlaze {

    public MainPageBlaze(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(linkText = "Laptops")
    WebElement laptopsButton;

    public void ckickLaptopsButton(){
        laptopsButton.click();
    }

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }
}
