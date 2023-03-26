package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.lang.module.Configuration;
import java.time.Duration;

public class OrderTest extends TestBaseBlaze {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
    @DataProvider(name = "customerInfo")
    public Object[] [] getData(){
        return new Object[][]{
                {"Ahmet","Turkey","Ankara", "134234", "12","1235"},
                {"John","USA","Chicago", "132345", "5","2026"},
                {"Phuong","Pak","Vietnam", "235325","3","2026"},


        };
    }

    @Test(dataProvider = "customerInfo")
    public void validateOrderFunctionality(String name,String country,String city,String creditCard,String month, String year ) throws InterruptedException {
        MainPageBlaze mainPageBlaze =new MainPageBlaze(driver);
        mainPageBlaze.ckickLaptopsButton();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop("MacBook Pro");
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,"Product added");
        mainPageBlaze.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.validateProductInformation("MacBook Pro", "1100");
        OrderPage orderPage=new OrderPage(driver);
        orderPage.clickOrderButton();
  //      orderPage.validateOrdertFunctionality("John","USA","Chicago",ConfigReader.readProperty("creditCard"),"12","2025","Thank you for your purchase!");
        orderPage.validateOrdertFunctionality(name,country,city,creditCard,month,year,"Thank you for your purchase!");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");

    }

}
