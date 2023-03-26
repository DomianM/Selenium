package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Facebook {

    /*
1-Navigate to the website "https://www.facebook.com/"
2-Click Create Account Button
3-Fill all the boxes
4-Choose Custom Gender
5-Choose any pronoun you want from
6-Click Sign up button
7-In general facebook has a protection to automate create account  so once you
click sign up button if there is a message then validate it. If no, just close or quit

   PURPOSE:
       1-This task can come during the interview
       2-How to deal with dynamic elements
     */

    @Test
    public void creatingFacebookAccount() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));//id is dynamic
        createAccountButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Dominic");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Fast ");
//        WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
//        mobile.sendKeys("123456789");
        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("sadfdc@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#password_step_input"));
        password.sendKeys("123456qwerty");
        WebElement month = driver.findElement(By.cssSelector("#month"));
        month.sendKeys("May");
        WebElement day = driver.findElement(By.cssSelector("#day"));
        day.sendKeys("13");
        WebElement year = driver.findElement(By.cssSelector("#year"));
        year.sendKeys("1991");

        WebElement customButton = driver.findElement(By.xpath("//label[contains(text(),'Custom')]"));
        customButton.click();
        WebElement pronoun = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
        pronoun.sendKeys("He: Wish him a happy birthday!");
        WebElement signUpButton = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUpButton.click();
        Thread.sleep(10000);

        WebElement message = driver.findElement(By.id("reg_error_inner"));
        String actualMessage="";
        String expectedMessege= message.getText().trim();








    }
}
