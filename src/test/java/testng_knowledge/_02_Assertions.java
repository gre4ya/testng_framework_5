package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Assertions {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        Assert.assertTrue(1 == 1);
        Assert.assertTrue(65 > 45);
        Assert.assertTrue(10 <= 10);
        Assert.assertTrue(3 + 5 <= 2 * 10);
    }

    @Test
    public void test2(){
        Assert.assertFalse(false);
        Assert.assertFalse(3 > 5);
    }

    @Test
    public void teat3(){
        Assert.assertEquals("hello", "hello");
        Assert.assertNotEquals("hello", "Hello");
    }

    @Test
    public void assertionMessages(){
        //Assert.assertTrue(false, "This validation FAILED");
        //Assert.assertEquals("Hello", "hello", "This two strings are not equal");
    }
    @Test
    public void testFail(){
        Assert.fail("This test fails due to BUG: 123ABC");
    }
}
