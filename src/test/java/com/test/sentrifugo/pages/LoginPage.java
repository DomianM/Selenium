package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public  LoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);//driver.findElement

    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;
    //Webelemrnt ahmet= driver.findElement
    @FindBy(xpath = "//div[contains(text(),'The username or password')]")

    WebElement errorMessage;
    public void login(String username, String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);//text
    }
    public  String validateColorOfErrorMessage(){
        return errorMessage.getCssValue("color").trim();//rgba color

    }

}
