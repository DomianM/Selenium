package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenCartTestNGPractice {

    //1 login successfully "demo" username and demo password and vilidate title
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(2000);

        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    //Negative test
    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("xxx");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("xxx");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement warning = driver.findElement(By.cssSelector("#alert"));

        String actualMassage = warning.getText().trim();
        String expectedMassage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMassage, expectedMassage);


    }

    @Test
    public void validateList() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement cancelButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        cancelButton.click();
        Thread.sleep(2000);

        WebElement catalogButton = driver.findElement(By.cssSelector("#menu-catalog"));
        catalogButton.click();
        Thread.sleep(2000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productsButton.isDisplayed());

    }

    @Test
    public void validateProductListButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement cancelButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        cancelButton.click();
        Thread.sleep(2000);

        WebElement catalogButton = driver.findElement(By.cssSelector("#menu-catalog"));
        catalogButton.click();
        Thread.sleep(2000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(2000);

        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {

            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            Assert.assertFalse(allBoxes.get(i).isSelected());// box is not selected so it will return false
            allBoxes.get(i).click();
            Thread.sleep(2000);
            Assert.assertTrue(allBoxes.get(i).isSelected());//true
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }

    }

    @Test
    public void validateReverse() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement cancelButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        cancelButton.click();
        Thread.sleep(2000);

        WebElement catalogButton = driver.findElement(By.cssSelector("#menu-catalog"));
        catalogButton.click();
        Thread.sleep(2000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();
        Thread.sleep(1000);

        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();

        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class= 'text-start']"));

        for (int i = 1; i < productNames.size(); i++) {

            actualNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Thread.sleep(1000);
        Collections.sort(expectedNames); // sorting fo asceding
        Collections.reverse(expectedNames); //making garantee
        System.out.println(expectedNames);
        System.out.println(actualNames);

        Assert.assertEquals(actualNames, expectedNames);

    }

    @Test
    public void validateProductNameFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement cancelButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        cancelButton.click();
        Thread.sleep(2000);

        WebElement catalogButton = driver.findElement(By.cssSelector("#menu-catalog"));
        catalogButton.click();
        Thread.sleep(2000);


        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();

        List <WebElement> productNames = driver.findElements(By.xpath("//td[@class= 'text-start']"));
        List <String> actualNames  = new ArrayList<>();
        List <String> expectedNames = new ArrayList<>();

        for ( int i = 1 ; i < productNames.size(); i ++ ){
            actualNames.add(productNames.get(i).getText().trim().toLowerCase());
            expectedNames.add(productNames.get(i).getText().trim().toLowerCase());
        }

        Collections.sort(expectedNames);
        Assert.assertEquals(expectedNames,actualNames);
        System.out.println(expectedNames);
        System.out.println("\n\n\n");
        System.out.println(actualNames);


    }
}








