package javaScriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class javaScriptPractice {

    @Test
    public  void javaScriptPractise() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        Thread.sleep(2000);

        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver,copyRight);
        String actualNameCopy = BrowserUtils.getText(copyRight);
        String expectedNameCopy ="Copyright © 2023";
        Assert.assertEquals(actualNameCopy,expectedNameCopy);
        Thread.sleep(3000);

        WebElement applyNowButton = driver.findElement(By.linkText("Apply Now"));
        BrowserUtils.scrollWithJS(driver,applyNowButton);
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver,applyNowButton);

        List<WebElement>allInformation = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String>expectedInformation = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        for (int i =0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInformation.get(i));
        }







    }




}
