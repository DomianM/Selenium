package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */
    @Test
    public void validateHeaderOfTheCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");

        WebElement newUsedBox = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsedBox, "New", "text");
        Thread.sleep(500);

        WebElement makeCarsBox = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(makeCarsBox, "Lexus", "text");
        Thread.sleep(500);

        WebElement modelsBox = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(modelsBox, "lexus-gs_350", "value");
        Thread.sleep(500);

        WebElement priceBox = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select actualPrice = new Select(priceBox);
        String actualPruiceText = actualPrice.getFirstSelectedOption().getText().trim();
        String expectedPriceText = "No max price";
        Assert.assertEquals(actualPruiceText, expectedPriceText);

        WebElement millageBox = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(millageBox, "40", "value");
        Thread.sleep(500);

        WebElement zipBox = driver.findElement(By.cssSelector("#make-model-zip"));
        zipBox.clear();
        zipBox.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.cssSelector(".sds-button"));
        searchButton.click();


        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";

        Assert.assertEquals(actualHeader, expectedHeader);

        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy, "Lowest price", "text");

        List<WebElement> allList = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
        for (int i = 0; i < allList.size(); i++) {
            Thread.sleep(1000);
            System.out.println(allList.get(i).getText().trim());


            Assert.assertTrue(BrowserUtils.getText(allList.get(i)).contains("Lexus RX 350"));
        }

        Thread.sleep(2000);
        driver.quit();




    }
}
