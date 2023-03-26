package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork7 {
    public static void main(String[] args) {
        /*
        Navigate to "https://www.saucedemo.com/"
Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not
match any user in this service" message
TIPS:to be able to see this message you need to first see this
message then try to inspect it. (it means at least run one time
with the username and password you provided above to see
the message then inspect the message.*be careful with it is
fully copied or not.
         */
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("Java");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Selenium");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualError = error.getText().trim();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualError.equals(expectedError)?"Pass":"Fail");


    }
}
