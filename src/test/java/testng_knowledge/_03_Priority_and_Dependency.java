package testng_knowledge;

import org.testng.annotations.Test;

public class _03_Priority_and_Dependency {

    @Test(priority = 1, enabled = false)
    public void login(){System.out.println("This is login");}
    @Test(dependsOnMethods = "login", enabled = false)
    public void logout(){System.out.println("This is logout");}
    @Test(dependsOnMethods = "logout", enabled = false)
    public void forgotPassword(){System.out.println("This is forgot password");}
    @Test(dependsOnMethods = "forgotPassword", enabled = false)
    public void invalidLogin(){System.out.println("This is invalid login");}
}
