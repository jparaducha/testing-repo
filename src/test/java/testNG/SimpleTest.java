package testNG;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {


    private  final Logger LOGGER = LogManager.getLogger(SimpleTest.class);

    int[] array1;
    int[] array2;
    MockClass mockClass;


    @BeforeClass(alwaysRun = true)
    public void BeforeClassMethod(){
        //LOGGER.info("Before class method");

        array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        array2 = new int[]{2,4,6,8,10,12};
    }


    @Test(groups = { "math" })
    public void testOddNumbers(){

        int result1 = mockClass.countOddNumbersInArray(array1);
        int result2 = mockClass.countOddNumbersInArray(array2);

        Assert.assertEquals(result1, 5, "odd numbers should be 5");
        Assert.assertEquals(result2, 0, "odd numbers should be 0");
    }

    @Test(groups = { "math" })
    public void testDivision(){

        boolean divisible1 = mockClass.isDivisible(10, 2);
        boolean divisible2 = mockClass.isDivisible(51,17);
        boolean divisible3 = mockClass.isDivisible(12.5, 3);

        Assert.assertEquals(divisible1,true, "number should be divisible");
        Assert.assertEquals(divisible2,true, "number should be divisible");
        Assert.assertEquals(divisible3,false, "number should not be divisible");
    }

    @Test(groups = { "string" })
    public void testHelloWorld(){
        String result = mockClass.helloWorld();

        Assert.assertEquals(result, "Hello World", "method should return Hello World");
    }


    @BeforeSuite( alwaysRun = true)
    public void BeforeSuite(){
        //LOGGER.info("Before suite");
    }

    @BeforeTest( alwaysRun = true)
    public void BeforeTest(){
        //LOGGER.info("Before test");

        mockClass = new MockClass();
    }


}
