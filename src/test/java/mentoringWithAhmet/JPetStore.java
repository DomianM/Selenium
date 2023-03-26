package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JPetStore {

    @Test
    public void validateCostMathFunctionality() throws InterruptedException {
/*
1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
3-Go to the main menu and choose 2 different category and choose one item from there
4-Add them into the card
5-Validate the total cost equals to the price at the bottom shows.
6-Quit

 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");

        WebElement fish = driver.findElement(By.xpath("//area[@alt='Fish']"));
        fish.click();

        Map<String,String> listOfFish = new HashMap<>();
        List <WebElement> allProductId = driver.findElements(By.xpath("//td[1]"));
        List <WebElement> allName = driver.findElements(By.xpath("//td[2]"));
        for (int i =0;i<allName.size();i++){
            listOfFish.put(BrowserUtils.getText(allProductId.get(i)),BrowserUtils.getText(allName.get(i)));


        }
        System.out.println(listOfFish);
        Thread.sleep(3000);

        driver.navigate().back();
        WebElement dog = driver.findElement(By.xpath("//area[@alt='Dogs']"));
        dog.click();
        Thread.sleep(3000);
        WebElement dalmation = driver.findElement(By.xpath("//td[.='Dalmation']//preceding-sibling::td//a"));
        dalmation.click();
        Thread.sleep(3000);
        WebElement addToCart = driver.findElement(By.xpath("//td[contains(text(),'Spotless')]//..//td[5]//a"));
        addToCart.click();
        Thread.sleep(3000);














    }
}
