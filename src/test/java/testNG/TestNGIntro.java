package testNG;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority = 1, invocationCount = 5)
    //test annotation --->
    public  void test1(){
              System.out.println("Test1");
          }
     @Test (priority = 3)
    public void test2(){
              System.out.println("Test2");
    }
     @Test(priority = 2, invocationCount = 1)
    public void test3(){
              System.out.println("Test3");
    }
}
