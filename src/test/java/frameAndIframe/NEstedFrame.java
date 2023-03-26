package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NEstedFrame {
    // Left, middle, right frame and validation headers

    @Test
    public void NestedFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(3000);

        WebElement topFrame = driver.findElement((By.name("frame-top")));
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualText = BrowserUtils.getText(left);
        String expectedText="LEFT";
        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        String actualMiddleText = BrowserUtils.getText(middleFrame);
        String expectedMiddleText = "MIDDLE";
        Assert.assertEquals(actualMiddleText,expectedMiddleText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String actualRightText = BrowserUtils.getText(rightFrame);
        String expectedRightText = "RIGHT";
        Assert.assertEquals(actualRightText,expectedRightText);

        //BOTTOM FRAME

//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();//main HTML
        driver.switchTo().defaultContent();// we use instead of parent frame, if parent frames so much
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualBottom = BrowserUtils.getText(bottom);
        String expectedBottom = "BOTTOM";
        Assert.assertEquals(actualBottom,expectedBottom);





    }
}
