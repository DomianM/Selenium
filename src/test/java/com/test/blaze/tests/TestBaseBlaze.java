package com.test.blaze.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class TestBaseBlaze {
    @BeforeSuite
    public void cleanTheCaches(){

        driver=DriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }


    public WebDriver driver;
    @BeforeMethod
    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver=DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");

    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if(!iTestResult.isSuccess()){
            Thread.sleep(3000);
            BrowserUtils.getScreenShot(driver,"blazepicture");
        }
        driver.quit();
    }
}
