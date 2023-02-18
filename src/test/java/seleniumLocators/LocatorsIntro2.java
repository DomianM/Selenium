package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/admin/Downloads/Techtorialhtml.html");
        //linktext locator

        WebElement javaLink = driver.findElement(By.linkText("Java"));//a tag with the text
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java") ? "Passed":"Failed");
        Thread.sleep(2000);// pause system for 2 sec the i can see what is going on
        driver.navigate().back();

        /*
        1.click selenium and validate (ternary)
        2. go back to the main page
        3. click cucumber and validate header
        4. go back to main page
        5.click testNG
        6.go back to the main page
        7.Validate the url file:///C:/Users/admin/Downloads/Techtorialhtml.html"

          */
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().equals("Selenium automates browsers. That's it!") ? "Passed":"Failed");
        driver.navigate().back();


        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.className("font-light"));
        System.out.println(cucumberLink.getText().trim().equals("Tools & techniques that elevate teams to greatness"));
        driver.navigate().back();

        String actualURL = driver.getCurrentUrl().trim();
        String expectedURL = "file:///C:/Users/admin/Downloads/Techtorialhtml.html";
        System.out.println(actualURL.equals(expectedURL) ? "Passed":"Failed");

        //PARTIAL KINK TEXT LOCATOR:
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        // WebElement restApi = driver.findElement(By.partialLinkText("Rest-api"));
        restApi.click();
        String actualURLResrApi = driver.getCurrentUrl();
        String expectedUrlRestAoi = "https://rest-assured.io/";
        System.out.println(actualURLResrApi.equals(expectedURL)? "Passed": "Failed");
        driver.navigate().back();
        driver.close();










    }
}
