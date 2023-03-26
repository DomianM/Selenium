package javaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethod {

    //we use JavaScripp method wen Selenium method are not working
    // as expectd. Specifically, click, getTitle
    //Note: we love using ScrollIntoView
    //

        @Test
    public  void  getTitle() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.navigate().to("https://www.techtorialacademy.com/");
            System.out.println(driver.getTitle()+"This is regular driver method for title");
            Thread.sleep(3000);
            //if this one is not working then i need to use JS method

            JavascriptExecutor js = (JavascriptExecutor) driver;//your driver is acting kike JS executor
            String title = js.executeScript("return document.title").toString();
            System.out.println(title + "This is JS method fo title");

    }
    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");


        WebElement radioButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));//selenium doesn't work here
        JavascriptExecutor js = (JavascriptExecutor) driver;// we use JS executor
        js.executeScript("arguments[0].click()",radioButton);

        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(3000);

        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()",impressiveButton);
        String actualImpressiveMessage = BrowserUtils.getText(message);
        String expectedImpressiveMessage = "You have selected Impressive";
        Assert.assertEquals(actualImpressiveMessage,expectedImpressiveMessage);




    }
    @Test//this is all about scrolling the page based on
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()true",findCourse);//***scroll to the element
        Thread.sleep(3000);
        js.executeScript("argument[0],click()",findCourse);//**
        System.out.println(js.executeScript("return document.title"));//*
    }
    @Test
    public void shortCutJSMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you']//.."));
        Thread.sleep(3000);
        BrowserUtils.scrollWithJS(driver,findCourse);
        BrowserUtils.clickWithJS(driver,findCourse);
        System.out.println(BrowserUtils.getTitleWithJS(driver));
    }
}
