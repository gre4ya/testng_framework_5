package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TechGlobalLogoTest extends TechGlobalBase{
        @Test
    public void validateTechGlobalLogo(){
       WebElement logo = driver.findElement(By.id("logo"));
       Assert.assertTrue(logo.isDisplayed()); // proper assertion with the TestNG//
    }
}
