package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText() throws InterruptedException {

        //OK ALERT BUTTON

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        //button[contains(text(),'click for')]
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String actualJSAlertText = alert.getText();//get the text from ALERT POP_UP
        String expectedJSAlertText = "I am a JS Alert";
        Assert.assertEquals(actualJSAlertText,expectedJSAlertText);
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(actualJSAlertText,expectedJSAlertText,"There is comparison problem");
        Thread.sleep(3000);
        alert.accept();//it is click OK button

        WebElement text = driver.findElement(By.cssSelector("#result"));
        String actualText = BrowserUtils.getText(text);//this is webElement, so i can use browser utils
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualText,expectedText);


    }
    @Test
    public void AlertDismiss() throws InterruptedException {
        //DISMISS ALERT BUTTON
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);//this is webElement, so i can use browser utils
        String expectedMessage = "You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(3000);



    }

        @Test
    public void sendKeys() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
       Thread.sleep(3000);

       WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
       ////button[contains(@onclick,'jsConfirm()')]")
       jsPrompt.click();
       Thread.sleep(3000);
       Alert alert = driver.switchTo().alert();
       alert.sendKeys("I love to automations");
       alert.accept();
       WebElement message = driver.findElement(By.cssSelector("#result"));
       String actualMessage = BrowserUtils.getText(message);//this is webElement, so i can use browser utils
       String expectedMessage = "You clicked: Cancel";
       Assert.assertEquals(actualMessage,expectedMessage);


    }
}
