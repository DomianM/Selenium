package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {

    WebDriver driver;
    @Test
    public void validateTheText(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement loading = driver.findElement(By.linkText("Dynamic Loading"));
        loading.click();
        WebElement hiddenElement = driver.findElement(By.partialLinkText("Example 1"));
        hiddenElement.click();
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        WebElement text = driver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!" );


    }
    @Test
    public void validateText2(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicControl=driver.findElement(By.xpath("//a[contains(text(),'Dynamic Controls')]"));
        dynamicControl.click();

        WebElement button = driver.findElement(By.xpath("//input[@type='checkbox']"));
        button.click();

        WebElement remove = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        remove.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");

    }

}
