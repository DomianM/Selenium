package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Basics {

    //select class is all about drop down
    //Drop box must have select tag name

    @Test
    public  void practiceSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));// a tag a text
        dropDown.click();

        //location of the box
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(optionBox);// provide location of the bpx inside of select object
        System.out.println(options.getFirstSelectedOption().getText().trim());//before options --->sout
        options.selectByValue("1");
        Thread.sleep(3000);
        options.selectByVisibleText("Option 2");//we provide visible text
        Thread.sleep(3000);
        options.selectByIndex(1);
        Thread.sleep(3000);
        System.out.println(options.getFirstSelectedOption().getText().trim());

        //validate
        List<WebElement> allOptions =  options.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option","Option 1","Option 2");
        for(int i =0;i<allOptions.size();i++){
            Assert.assertEquals(allOptions.get(i).getText().trim(), expectedOptions.get(i));
        }




    }
}
