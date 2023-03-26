package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class alertPractice {
    @Test
    public void practiceAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        driver.findElement(By.cssSelector("#alertBox")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        Thread.sleep(3000);
        WebElement result = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(result),"You selected alert popup");


        driver.findElement(By.cssSelector("#confirmBox")).click();
        alert.dismiss();
        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(result),"You pressed Cancel in confirmation popup");

        driver.findElement(By.cssSelector("#promptBox")).click();
        alert.sendKeys("Hello");
        alert.accept();
        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(result),"You entered text Hello in propmt popup");







    }

}
