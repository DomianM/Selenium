package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)

    //1- Set up automation
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //create driver object
        WebDriver driver = new ChromeDriver();
        //3.Go to website and maximize your screen
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
        String actualTile = driver.getTitle().trim();//comes from system
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";//comes from me
        System.out.println(actualTile);

        System.out.println(actualTile.equals(expectedTitle) ? "Title pass":"Title failed");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";


        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL Passed");
        }else{
            System.out.println("URL Failed");
            driver.close();
        }
    }
}
