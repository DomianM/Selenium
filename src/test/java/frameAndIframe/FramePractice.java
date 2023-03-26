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

public class FramePractice {

    @Test
    public void iframePractice() throws InterruptedException {
        /*
 1-Navigate To the website "https://the-internet.herokuapp.com/iframe"
 2-Validate the header "An iFrame containing the TinyMCE WYSIWYG Editor"
 3-Clear the message and send "I love Selenium"
 4-Click Elemental Selenium link
 5-Validate the header "Elemental Selenium"

 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.tagName("h3"));
        String  actualHeader = header.getText().trim();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader);
        Thread.sleep(300);
        driver.switchTo().frame("mce_0_ifr");//open the door
        WebElement messageBox= driver.findElement(By.cssSelector("#tinymce"));
        messageBox.clear();
        messageBox.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
        BrowserUtils.switchByTitle(driver,"Using Selenium like a Pro");
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader = BrowserUtils.getText(seleniumHeader);
        String expectedSeleniumHeader = "Elemental Selenium";
        Assert.assertEquals(actualHeader,expectedHeader);



    }
}
