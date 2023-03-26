package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {

    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrderButton;
//    public void clickOrderButton(){
//        placeOrderButton.click();
//  }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='card']")
    WebElement card;

    @FindBy(xpath = "//input[@id='month']")
    WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement thankMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void clickOrderButton(){
        placeOrderButton.click();
    }
    public void validateOrdertFunctionality(String name, String country, String city, String card,String month, String year,String expectedMessage) throws InterruptedException {
       Thread.sleep(1000);
        this.name.sendKeys(name);
Thread.sleep(1000);
        this.country.sendKeys(country);
        Thread.sleep(1000);

        this.city.sendKeys(city);
        Thread.sleep(1000);

        this.card.sendKeys(card);
        Thread.sleep(1000);

        this.month.sendKeys(month);
        Thread.sleep(1000);

        this.year.sendKeys(year);
        Thread.sleep(1000);

        purchaseButton.click();
        Thread.sleep(1000);

        Assert.assertEquals(BrowserUtils.getText(thankMessage),expectedMessage);
        Thread.sleep(1000);

        okButton.click();
    }




}
