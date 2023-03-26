package mentoringWithAhmet.bank.tests;

import mentoringWithAhmet.bank.pages.BankLoginPage;
import mentoringWithAhmet.bank.pages.CustomerPage;
import org.testng.annotations.Test;

public class CustomerTest extends BankTestBase{

    @Test
    public void validateCustomerLoginFunctionality() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.selectCustomer("Harry Potter");
        customerPage.validateDepositFunctionality("500");

    }

}
