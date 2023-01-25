package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _05_SoftAssertion {
    @Test(enabled = false)
    public void hardAssertionExample(){
        Assert.assertTrue(true);
        Assert.assertEquals("Hello", "abc");
        System.out.println("Hard Assertion test");//"Hard assertion will not be printed".Exception will be thrown at line 11
    }

    @Test(enabled = false)
    public void softAssertionExample(){
        // First we need to create an object of SoftAssert class

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(2==2);
        softAssert.assertEquals("Hello", "abc");

        System.out.println("Soft Assertion test");

        softAssert.assertAll();
    }
}
