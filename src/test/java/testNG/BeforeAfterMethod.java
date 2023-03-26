package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {

    @BeforeMethod
    @Test
    public void hello1() {
        System.out.println("test1");
    }

    @Test
    public void hello2() {
        System.out.println("test1");


    }

    @Test
    public void hello3() {
        System.out.println("test1");

    }
    @AfterMethod
    public void afterMethod(){

        System.out.println("After Method");
    }
}

