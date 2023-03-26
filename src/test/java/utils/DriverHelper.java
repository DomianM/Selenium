package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;

import java.rmi.Remote;
import java.time.Duration;

import static org.openqa.selenium.remote.HttpSessionId.getSessionId;

public class DriverHelper {
    private static WebDriver driver;

    private DriverHelper() {
    }
    //i make my constructor private because i do not want anyone to create an object
    //and manipulate my driver from this class
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("--remote-allow-origins=*");
    //driver = new ChromeDriver(options);


    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            String browser = "chrome";
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions option1 = new ChromeOptions();
                    option1.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(option1);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

}
