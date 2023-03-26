package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPageBlaze;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest extends TestBaseBlaze {

    /*
  1-Navigate to the website "https://www.demoblaze.com/#"
  2-Click the Laptops from homepage(firstPage)
  3-Click MacBook Pro from the list with Loop(LaptopPage)
  4-Validate the header="MacBook Pro"(MacBook Pro Page)
  5-Validate the price=$1100 *includes tax(MacBook Pro Page)
  6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multi-touchstrip display that sits above the MacBook Pro's keyboard."
  7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button
   */
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
    @Parameters({"laptopBrand","laptopPrice","message","description"})
    @Test
    public void validateMacBookProInfo(String laptopBrand, String  laptopPrice, String massage,String description) throws InterruptedException {
            MainPageBlaze mainPageBlaze = new MainPageBlaze(driver);
            mainPageBlaze.ckickLaptopsButton();
            LaptopPage laptopPage = new LaptopPage(driver);
            laptopPage.chooseLaptop(laptopBrand);
            MacBookProPage macBookProPage = new MacBookProPage(driver);
            macBookProPage.validateProductInformation(laptopBrand,laptopPrice,description);
            macBookProPage.clickAddToCartButton(driver,massage);

        }
//        @AfterMethod
//    public  void tearDown(){
//             driver.quit();
//        }
    }

