package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //windows user will add chromdriver.exe
        WebDriver driver = new ChromeDriver();//create object
        driver.manage().window().maximize();//mzximaze
        driver.get("https://www.amazon.com/");//navigate to wedsite
        System.out.println(driver.getTitle());//get title
        String actualTitle = driver.getTitle();
        String expectedTitle ="Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){//validation here

            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        //driver.getCurrentUrl();
        driver.get("https://www.techtorialacademy.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techtorialacademy.com/";
        String actualTileTechtorial = driver.getCurrentUrl();
        String actualTitleTechtorial = driver.getTitle();
        String expectedTitleTechtorial = "Home";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL Passed");
        }else   {
            System.out.println("URL Failed");
        }
        if(actualTileTechtorial.equals(expectedTitleTechtorial)){
            System.out.println("Title passed");
        }else{
            System.out.println("Title failed");
        }


    }
}
