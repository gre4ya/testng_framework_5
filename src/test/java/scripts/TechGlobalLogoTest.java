package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TechGlobalLogoTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // We will set up our driver and the pages
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void validateTechGlobalLogo(){
          // Do your test here
            driver.get("https://techglobal-training.netlify.app");
            WebElement logo = driver.findElement(By.id("logo"));
            Assert.assertTrue(logo.isDisplayed()); // proper assertion with the TestNG
        }


        @AfterMethod
    public void teardown(){
          // We will quit driver and do other proper cleanups
            driver.quit();
        }
}
