package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public int multiplicaton(int number1,int number2){
             return number1*number2;
    }

    @Test
    public void validateMultiplication(){
        int actualResult = multiplicaton(3,4);
        int expectedResult = 12;
        Assert.assertEquals(actualResult,expectedResult);

    }
    @Test
    public  void validateZero(){
        int actual = multiplicaton(1,99999);
        int expected =0;
        Assert.assertTrue(actual==expected);

    }

    @Test
    public void validateNegativeWithPositive(){
        int actual = multiplicaton(-1,9);
        int expected = -9;
        Assert.assertFalse(actual!=expected);//negative scenario


    }

    @Test
    public void validateNegativeWithPositive1(){
        int actual = multiplicaton(-1,-7);
        int expectd = 7;
        Assert.assertEquals(actual,expectd);

    }
}
