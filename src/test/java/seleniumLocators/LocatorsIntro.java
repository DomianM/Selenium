package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    //ID LOCATOR:
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/admin/Downloads/Techtorialhtml.html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();//Tectorial academy
        String expectedHeader = "Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText().trim());



        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement secondName = driver.findElement(By.name("lastName"));
        secondName.sendKeys("Baldir");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("15616");
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("sdfs@dg.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("Chicago");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement zip = driver.findElement(By.name("postalCode"));
        zip.sendKeys("12345");
        Thread.sleep(3000);


        //CLASS LOCATORS:
        WebElement checkboxesLabel = driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }
        WebElement ngBox = driver.findElement(By.id("cond3"));
        if(ngBox.isDisplayed() && !ngBox.isSelected()){
            ngBox.click();
        }
        WebElement cucumber = driver.findElement(By.id("cond4"));
        if(cucumber.isDisplayed()&&!cucumber.isSelected()){
            cucumber.click();
        }
        //TAG NAME LOCATOR:

        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion = version.getText().trim();
        String expectedVersion = "Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion)?"Passed":"Failed");

    }
}
