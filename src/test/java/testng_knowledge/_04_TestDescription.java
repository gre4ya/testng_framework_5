package testng_knowledge;

import org.testng.annotations.Test;

public class _04_TestDescription {

    @Test(priority = 1)
    public void login(){
        System.out.println("This is login");
    }
    @Test(priority = 2)
    public void invalidLogin(){
        System.out.println("This is invalid login");
    }


}
