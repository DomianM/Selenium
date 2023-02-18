package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {

    public static void main(String[] args) {
        //set up automation
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        //Automation process  ---> check registration functionality
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("dmitrii");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("mangov");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        email.sendKeys("ad454df@gmail.cpm");
        WebElement phone=driver.findElement(By.xpath("//input[@type='tel']"));
        phone.sendKeys("2345678");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("12367");
        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("12367");
        WebElement privacyButton=driver.findElement(By.xpath("//input[@name='agree']"));
        privacyButton.click();
        WebElement continueButton= driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account'"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Your Account Has Been Created";
        System.out.println(actualHeader.equals(expectedHeader)? "Passed":"Failed");
    }
}
