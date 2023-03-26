package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void swithcWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        String mainPageID = driver.getWindowHandle();//pageID of the class
        System.out.println(mainPageID);
        Set<String> allPageID = driver.getWindowHandles();//return all id
        System.out.println(allPageID);
        for (String id : allPageID) {
            //this is use for only 2 tab/windows
            if (!id.equals(mainPageID)) {
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));


    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Thread.sleep(2000);

        WebElement button2 = driver.findElement(By.cssSelector("#newTabBtn"));
        button2.click();

        String mainPageID = driver.getWindowHandle();
        Set<String> allPageID = driver.getWindowHandles();
        for (String id : allPageID) {
            if (!id.equals(mainPageID)) {
                driver.switchTo().window(id);
            }

        }

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);

        String actualTitle = driver.getTitle();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement clickMe = driver.findElement(By.cssSelector("#alertBox"));
        clickMe.click();



    }
}