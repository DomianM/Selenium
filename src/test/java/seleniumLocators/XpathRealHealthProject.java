package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {
         /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.*/
         public static void main(String[] args) throws InterruptedException {
             System.setProperty("webdriver.chrome.driver","chromedriver.exe");
             WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             driver.get("https://katalon-demo-cura.herokuapp.com/");

             //2-Click Make an Appointment
             WebElement makeAnAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
             makeAnAppointmentButton.click();
             //3-Login the username and password provided and Login successfully
             WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
             username.sendKeys("John Doe");
             WebElement password = driver.findElement(By.xpath("//input[@id ='txt-password']"));
             password.sendKeys("ThisIsNotAPassword");
                          WebElement loginButton = driver.findElement(By.xpath("//button[@id ='btn-login']"));
             loginButton.click();

             WebElement chooseFacilityButton = driver.findElement(By.xpath("//select[@id='combo_facility']"));
             chooseFacilityButton.sendKeys("Hongkong CURA Healthcare Center");

             WebElement hospitalAdmission = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
             if(hospitalAdmission.isDisplayed() && !hospitalAdmission.isSelected() && hospitalAdmission.isEnabled()){
                 hospitalAdmission.click();
             }
             WebElement healthCare = driver.findElement(By.xpath("//input[@value='Medicaid']"));
             healthCare.click();

             WebElement visitData = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
             visitData.sendKeys("28/02/2023");

             WebElement textBox = driver.findElement(By.xpath("//textarea"));
             textBox.sendKeys("Hello");

             WebElement bookYourAppButton = driver.findElement(By.xpath("//button[contains(text(),'Book Appointment')]"));
             bookYourAppButton.click();

             WebElement appConfirmHeader = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
             String actualAppConfirmHeader = appConfirmHeader.getText().trim();
             String expectedAppConfirmHeader = "Appointment Confirmation";
             System.out.println(actualAppConfirmHeader.equals(expectedAppConfirmHeader)? "Pass":"Fail");

             WebElement mainPage = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
             mainPage.click();

             System.out.println(driver.getCurrentUrl().trim());
             Thread.sleep(3000);

             driver.close();
         }


}
