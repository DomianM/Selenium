package mentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techList {
        /*
    1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
Try your own logic and automate it without any help.
     */
        public static void main(String[] args) {
            System.setProperty("webdriver.chrom.driver","Chromdriver.exe");
            //Set tour automation
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            //You need a driver to make connect between page ang intelliJ
            driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

            //2-Enter first and last name (textbox)
            WebElement firstName = driver.findElement(By.name("firstname"));
            firstName.sendKeys("Dmitrii");
            WebElement lastName = driver.findElement(By.name("lastname"));
            lastName.sendKeys("Mangov");

            //3-Select gender (radio button).
            WebElement maleRadioButton = driver.findElement(By.id("sex-0"));
            if(maleRadioButton.isDisplayed() && !maleRadioButton.isSelected()){
                maleRadioButton.click();
            }
            WebElement femaleRadioButton = driver.findElement(By.id("sex-1"));
            if(femaleRadioButton.isDisplayed() && !femaleRadioButton.isSelected()){
                femaleRadioButton.click();
            }
            //4-Select years of experience (radio button).
            WebElement experience = driver.findElement(By.id("exp-1"));
            experience.click();

            //5-Enter date.(send keys)
            WebElement data = driver.findElement(By.id("datepicker"));
            data.sendKeys("02/14/2023");
            //6-Select Profession (Checkbox).
            WebElement automation = driver.findElement(By.id("profession-1"));
            if (automation.isSelected() && automation.isDisplayed()){
                automation.click();
            }
            WebElement tool = driver.findElement(By.id("tool-2"));
            tool.click();
            WebElement continent = driver.findElement(By.id("continents"));
            continent.click();
            WebElement button = driver.findElement(By.className("btn-info"));
            button.click();








        }
}
