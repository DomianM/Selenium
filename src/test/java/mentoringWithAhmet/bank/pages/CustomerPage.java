package mentoringWithAhmet.bank.pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.text.BreakIterator;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

     @FindBy(css = "#userSelect")
    WebElement customer;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement headerMessage;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositTop;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depositMessage;

    public void selectCustomer(String name) throws InterruptedException {
        BrowserUtils.selectBy(customer,name,"text");
        Thread.sleep(1000);
        loginButton.click();
    }
    public String validateWelcomeMessage(String expectedMessage){
        return BrowserUtils.getText(headerMessage);
    }
    public void validateDepositFunctionality(String amount) throws InterruptedException {
        depositTop.click();
        Thread.sleep(1000);
        this.amount.sendKeys(amount);
        Thread.sleep(1000);
        depositButton.click();
        Assert.assertEquals(BrowserUtils.getText(depositMessage),"Deposit Successful");

    }
}
