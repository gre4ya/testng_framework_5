package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Extent_Reports {

    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Test 1");

        test.log(Status.INFO, "Starting the test");
        driver.get("https://google.com");

        test.pass("Navigation to google.com");

        driver.findElement(By.name("q")).sendKeys("Automation");

        test.pass("Entered text in Searchbar");

        driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

        test.pass("Pressed Enter key");

        driver.close();

        driver.quit();

        test.pass("Closed the browser");

        test.info("Test Completed");

        extent.flush();



    }
}
