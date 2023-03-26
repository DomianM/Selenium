package mentoringWithAhmet.bank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class BankTestBase {

    public  WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"Bank");
    }

}
