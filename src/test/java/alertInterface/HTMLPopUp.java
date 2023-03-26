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

public class HTMLPopUp {

    @Test
    public void htmlPopUpPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement JSPreviewButton1 = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        JSPreviewButton1.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Oops, something went wrong!");
        alert.accept();
        Thread.sleep(2000);

        WebElement HTMLPreviewButton = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        HTMLPreviewButton.click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        System.out.println(BrowserUtils.getText(text));//for me
        Assert.assertTrue(BrowserUtils.getText(text).contains("Something went wrong!"));
        text.click();
        Thread.sleep(3000);
        driver.quit();









    }
}
