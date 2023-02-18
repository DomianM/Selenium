package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class getAttribute {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAnAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAnAppointmentButton.click();

        WebElement demoUserName = driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(demoUserName.getText().trim());//JonDoe//Dont work
        System.out.println(demoUserName.getAttribute("value"));
        System.out.println(demoUserName.getAttribute("placeholder"));
    }

}
