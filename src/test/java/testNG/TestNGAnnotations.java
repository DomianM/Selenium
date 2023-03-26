package testNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuit(){//it will run before everything ---> clear the cookies and coaches
        System.out.println("I am beforeSuite Annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am BeforeTest Annotation");
    }

    @BeforeClass
    public void beforeClass(){//it runs before every class and people use to launch their broweser driver = DriverHelper.getDriver()
        System.out.println("I am before class Annotation");
    }

    @BeforeMethod
    public void beforeMethod(){//it runs before evry test annotation and it is good to use for setting up your automation
        System.out.println("I am Before Method Annotation");
    }


    @Test
    public void test(){
        System.out.println("I am test Annotation");
    }
    @Test//it execute the code
    public void test1(){
        System.out.println("I am second test Annotation");
    }
    @AfterMethod
    public void afterMethod(){//itruns after every test annotation and it is good use for screenshot and quit your driver
        System.out.println("I am after method Annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class Annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am AfterTest Annotation");
    }
    @BeforeSuite
    public  void afterSuite(){
        System.out.println("I am after suite Annotation");
    }
}
