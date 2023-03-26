package com.test.blaze.pages;

import com.test.bank.pages.ManagerPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;
import utils.BrowserUtils;

import java.util.concurrent.BrokenBarrierException;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2")
    WebElement header;

    @FindBy(tagName = "h3")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    public void validateProductInformation(String laptopHeader, String laptopPrice, String laptopDescription){
        Assert.assertEquals(BrowserUtils.getText(header),laptopHeader);
        Assert.assertEquals(BrowserUtils.getText(price),laptopPrice);
        Assert.assertTrue(BrowserUtils.getText(description).contains(laptopDescription));

    }
    public void clickAddToCartButton(WebDriver driver, String expectedMessage) throws InterruptedException {

        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedMessage);
        alert.accept();

    }


}
