package testng_knowledge;

import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

public class _07_Groups {

    @Test(groups = "Smoke")
    public void test1(){
        System.out.println("This is a SMOKE test case");
    }
    @Test(groups = {"Regression","Integration"})
    public void test2(){
        System.out.println("This is a REGRESSION and INTEGRATION test case");
    }
    @Test(groups = "Smoke")
    public void test3(){
        System.out.println("This is a SMOKE test case");
    }
    @Test(groups = "Regression")
    public void test4(){
        System.out.println("This is a REGRESSION test case");
    }
    @Test(groups = "Regression")
    public void test5(){
        System.out.println("This is a REGRESSION test case");
    }
    @Test(groups = "Integration")
    public void test6(){
        System.out.println("This is a INTEGRATION test case");
    }
}
