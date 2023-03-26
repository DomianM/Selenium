package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBankPage {

    public LoginBankPage(WebDriver driver){
        PageFactory.initElements(driver,this);


    }
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerButton;
    public void  clickBankManagerButton(){
        bankManagerButton.click();
    }






}
