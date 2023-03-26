package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.compression.BrotliEncoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PracticeActions {

    @Test
    public void validateMessageAndColor() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        Thread.sleep(3000);

        WebElement smallBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200,200);
        actions.dragAndDrop(smallBox,bigBox).perform();

        String actualMessage = BrowserUtils.getText(bigBox);
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor = bigBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }
    @Test
    public  void validateNoAcceptableFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        WebElement accept = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        accept.click();
        Thread.sleep(1500);

        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        String actualNotAcceptable = BrowserUtils.getText(notAcceptable);
        String expectedNotAcceptable = "Not Acceptable";
        Assert.assertEquals(actualNotAcceptable, expectedNotAcceptable);

        Thread.sleep(1000);
        WebElement dropArea = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id = 'droppable']"));
        actions.clickAndHold(notAcceptable).moveToElement(dropArea).release().perform();

        WebElement dropText = driver.findElement(By.xpath("//div[@class='accept-drop-container']//p[contains(text(), 'Drop here')]"));

        String actualDropText = BrowserUtils.getText(dropText);
        String expectedDropText = "Drop here";
        Assert.assertEquals(actualDropText, expectedDropText);



        ;



    }
}
