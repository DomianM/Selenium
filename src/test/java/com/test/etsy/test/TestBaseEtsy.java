package com.test.etsy.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.html.HTMLBRElement;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseEtsy {
    public WebDriver driver;
    @BeforeMethod
    public  void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("etsyUrl"));
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"etsy");
        //driver.quit(); because  we dont see if something wrong -what part?
    }

}
