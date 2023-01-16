package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalJavaExercisesHomePage;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalJavaExercisesHomePage techGlobalJavaExercisesHomePage;
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get("https://techglobal-training.netlify.app");
        techGlobalBasePage = new TechGlobalBasePage();
    }
    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
