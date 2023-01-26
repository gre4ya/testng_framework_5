package testng_knowledge;

import org.testng.annotations.Test;
import utilities.Waiter;

public class _09_Parallel_Test {

    @Test(enabled = false)
    public void method1(){
        Waiter.pause(5);
        System.out.println("This is method 1 in the 09 class");
        System.out.println("Thread = " + Thread.currentThread().getId());
    }
    @Test(enabled = false)
    public void method2(){
        Waiter.pause(4);
        System.out.println("This is method 2 in the 09 class");
        System.out.println("Thread = " + Thread.currentThread().getId());
    }
    @Test(enabled = false)
    public void method3(){
        Waiter.pause(6);
        System.out.println("This is method 3 in the 09 class");
        System.out.println("Thread = " + Thread.currentThread().getId());
    }
}
