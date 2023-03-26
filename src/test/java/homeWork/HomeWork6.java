package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork6 {
    public static void main(String[] args)  {
        /*
        Navigate to "https://demoqa.com/radio-button"
Click Yes radio button
Validate text is : You have selected Yes
Click Impressive radio button
Validate text is : You have selected Impressive
TIPS: be careful about your xpath if you have any issue with
getting the text.
         */
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@type='radio']"));
        if(yesButton.isDisplayed()&&!yesButton.isSelected()){
            yesButton.click();
        }
        WebElement textYes1 = driver.findElement(By.xpath("//p[@contains(text(),'You have selected')]"));
        String actualTextYes = textYes1.getText().trim();
        String expectedTextYes = "You have selected";
        System.out.println(actualTextYes.equals(expectedTextYes)?"Pass":"Fail");

//        WebElement textYes2 = driver.findElement(By.xpath("//span[@class='text-success']"));
//        String actualTextYes2 = textYes2.getText().trim();
//        String expectedTextYes2 = "Yes";
//        System.out.println(actualTextYes2.equals(expectedTextYes2)?"Pass":"Fail");








    }
}
