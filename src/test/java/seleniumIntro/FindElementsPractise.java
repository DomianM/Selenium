package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractise {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> allBoxes = driver.findElements(By.tagName("li"));
        int count1 =0;
        for (WebElement box : allBoxes) {
            System.out.println(box.getText().trim());
            count1++;
        }
        System.out.println(count1);
        System.out.println(allBoxes.size());
        //print ouy woras letter more than equal 12
        int count2=0;
        for(WebElement box:allBoxes){
            if(box.getText().trim().length()>=12);
            count2++;
        }
        System.out.println(count2);



    }
}




