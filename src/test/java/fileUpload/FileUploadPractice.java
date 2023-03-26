package fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton=driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\admin\\Downloads\\usa (1).png");

        WebElement fileUploadButton=driver.findElement(By.cssSelector("#file-submit"));
        fileUploadButton.click();
        WebElement message = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(message),"usa (1).png");
        driver.quit();


    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");


        WebElement chooseFileButton=driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFileButton.sendKeys("C:\\Users\\admin\\Downloads\\usa (1).png");

        WebElement text=driver.findElement(By.xpath("//b[contains(text(),'Select file to send')]"));
        //div[@id='uploadmode3']//preceding-sibling::div
        //div[@id='uploadmode3']//following-sibling::span//b
        //*[@id="file_wraper0"]/div

        String actualText = BrowserUtils.getText(text);
        String expectedText = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText,expectedText);

        WebElement termsBox = driver.findElement(By.cssSelector("#terms"));////a[.='terms of service']//preceding-sibling::input
        if(!termsBox.isSelected()&& termsBox.isDisplayed()){
            termsBox.click();
            Thread.sleep(2000);
        }
        WebElement submitButton = driver.findElement(By.cssSelector("#submitbutton"));
        //submitButton.click();
        submitButton.submit();
        WebElement message = driver.findElement(By.tagName("h3"));
        String actualMess = BrowserUtils.getText(message);
        String expectdMess = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMess,expectdMess);


    }
}
