package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SelectPractice {
    @Test
    public  void selectPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/admin/Downloads/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);

        String actualFirstOption = country.getFirstSelectedOption().getText().trim();//United States
        String expectedFirstOption = "UNITED STATES";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);



        List<WebElement> allCountryOption = country.getOptions();


        int counter = 0;
        for(WebElement countryName:allCountryOption){
            System.out.println(countryName.getText().trim());
            counter++;
        }
        System.out.println(counter);

        country.selectByVisibleText("BAHAMAS ");
        Thread.sleep(2000);
        country.selectByValue("253");
        Thread.sleep(2000);
        country.selectByIndex(45);
        Thread.sleep(2000);






    }
    @Test
    public  void multiSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/admin/Downloads/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.cssSelector(".select"));
        Select country = new Select((countryBox));
        country.selectByVisibleText("One");
        Thread.sleep(2000);
        country.selectByValue("3");
        Thread.sleep(2000);
        country.selectByIndex(4);
        Thread.sleep(2000);
        //country.selectByVisibleText("One");
        country.deselectByIndex(0);
        Thread.sleep(2000);
        country.deselectAll();


    }

    @Test
    public  void  validateOrderMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement flightType = driver.findElement(By.xpath("//input[@value='oneway']"));
        flightType.click();
        Thread.sleep(3000);

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select PassengersOptions = new Select(passengers);
        PassengersOptions.selectByVisibleText("4");
        Thread.sleep(3000);

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingOptions = new Select(departingFrom);
        String selectedExpected = "Acapulco";
        Assert.assertEquals(departingOptions.getFirstSelectedOption().getText(), selectedExpected);

        departingOptions.selectByValue("Paris");

        WebElement on = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onSelect = new Select(on);
        onSelect.selectByVisibleText("August");
        Thread.sleep(500);


        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDaySelect = new Select(onDay);
        onDaySelect.selectByVisibleText("15");
        Thread.sleep(500);


        WebElement arrive = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriveSelect = new Select(arrive);
        arriveSelect.selectByVisibleText("San Francisco");
        Thread.sleep(500);


        WebElement toDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toDateSelect = new Select(toDate);
        toDateSelect.selectByVisibleText("December");
        Thread.sleep(500);


        WebElement onMonth = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select onMonthSelect = new Select(onMonth);
        onMonthSelect.selectByVisibleText("15");
        Thread.sleep(500);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(500);

        WebElement airline = driver.findElement(By.xpath("//select [@name='airline']"));
        Select airlineOptions = new Select(airline);
        airlineOptions.selectByVisibleText("Unified Airlines");
        Thread.sleep(500);


        WebElement validation = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airValidation = new Select(validation);

        List<WebElement> actualValidation = airValidation.getOptions();
        List<String> expectedValidation = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualValidation.size(); i++) {
            Assert.assertEquals(actualValidation.get(i).getText(), expectedValidation.get(i));
        }


        WebElement count = driver.findElement(By.xpath("//input[@name='findFlights']"));
        count.click();
        Thread.sleep(500);


        WebElement validation2 = driver.findElement(By.xpath("//font[@size='4']"));
        String actual = validation2.getText().trim();
        String expected = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(actual, expected);

        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void shortCutsSelectClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement flightType = driver.findElement(By.xpath("//input[@value='oneway']"));
        flightType.click();
        Thread.sleep(3000);


        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        //BrowserUtils.selectBy(passengers, "4", "index");
        Thread.sleep(3000);


        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingOptions = new Select(departingFrom);
        String selectedExpected = "Acapulco";
        Assert.assertEquals(departingOptions.getFirstSelectedOption().getText(), selectedExpected);
        departingOptions.selectByValue("Paris");


        WebElement on = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(on, "August", "text");
        Thread.sleep(500);


        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Thread.sleep(500);
        BrowserUtils.selectBy(onDay, "15", "text");


        WebElement arrive = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrive, "San Francisco", "text");
        Thread.sleep(500);



        WebElement toDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toDate, "December", "text");
        Thread.sleep(500);

        WebElement onMonth = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(onMonth, "15", "text");
        Thread.sleep(500);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(500);

        WebElement airline = driver.findElement(By.xpath("//select [@name='airline']"));
        BrowserUtils.selectBy(airline, "Unified Airlines", "text");
        Thread.sleep(500);

        WebElement validation = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airValidation = new Select(validation);

        List<WebElement> actualValidation = airValidation.getOptions();
        List<String> expectedValidation = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualValidation.size(); i++) {
            Assert.assertEquals(actualValidation.get(i).getText(), expectedValidation.get(i));
        }

        WebElement count = driver.findElement(By.xpath("//input[@name='findFlights']"));
        count.click();
        Thread.sleep(500);

        WebElement validation2 = driver.findElement(By.xpath("//font[@size='4']"));
        //String actual = validation2.getText().trim();
        String actualMessage = BrowserUtils.getText(validation2);
        String expectedMessage = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(actualMessage, expectedMessage);

        Thread.sleep(5000);
        driver.quit();

    }

}

