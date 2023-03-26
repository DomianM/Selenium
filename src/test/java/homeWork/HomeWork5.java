package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork5 {
    public static void main(String[] args) {

        /*
        Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address
Click submit button.
Validate that all of your information is displayed and
matching correctly.
TIPS:Think about if conditions.
Example:
Name:David
Email: david@gmail.com
Current Address :Random Address
Permananet Address : different address
         */
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("David");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("david@gmail.com");

        WebElement currentAdress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAdress.sendKeys("Random Address");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("different address");
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        permanentAddress.sendKeys(Keys.ARROW_DOWN);
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();
    }
}
