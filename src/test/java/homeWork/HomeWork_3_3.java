package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork_3_3 {
    /*
Navigate to the "http://uitestpractice.com/Students/Index"
Search your Lastname in search bar
Click Edit button
Change first name
Click save button
Search with new firstname
Validate Firstname is changed
     */
    @Test
    public  void homeWork10(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/Students/Index");

        WebElement searchBox = driver.findElement(By.cssSelector("#Search_Data"));
        searchBox.sendKeys("Dima");
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        driver.navigate().back();

        //WebElement editButton = driver.findElement(By.xpath("/table/tbody/tr/td/button[contains(text(),'EDIT')]"));
        WebElement editButton = driver.findElement(By.xpath("/button[contains(@onclick,'Edit')]"));

        editButton.click();////button[contains(@onclick,'swal')]
////        WebElement createNew = driver.findElement(By.xpath("//a[contains(text(),'Create New')]"));
////        createNew.click();



    }
}
