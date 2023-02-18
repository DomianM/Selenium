package homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.microsoft.com/en-us/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Microsoft – Cloud, Computers, Apps & Gaming";
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
