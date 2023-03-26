package com.test.uitestpractice.test;

import com.test.uitestpractice.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

import java.util.Arrays;
import java.util.List;

public class Test {


                /*
        Navigate to
"http://uitestpractice.com/Students/Select#"
1.Validate India is selected by default on drop down
box
2.Validate the size of the Drop down box is 4
3.Validate the values for Drop down box are : India, United States of America,China,England
4.Select the China with index number
5.Select the England with value
6.Select the United States with visible text */

    public WebDriver driver;
    @BeforeMethod
    public void setup() {

        driver= DriverHelper.getDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
    }
    @org.testng.annotations.Test
    public void validateDropDownBox(){
        MainPage mainPage=new MainPage(driver);
        mainPage.validateDefaultIndia("India");

    }
}
