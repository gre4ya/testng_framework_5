package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class TechGlobalBase {
    WebDriver driver;
    SoftAssert softAssert;
    Actions actions;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalJavaExercisesHomePage techGlobalJavaExercisesHomePage;
    TechGlobalDynamicElementsPage techGlobalDynamicElementsPage;
    TechGlobalWaitsPage techGlobalWaitsPage;
    TechGlobalRadioButtonsPage techGlobalRadioButtonsPage;
    TechGlobalCheckBoxPage techGlobalCheckBoxPage;
    TechGlobalDropdownsPage techGlobalDropdownsPage;
    TechGlobalMultipleWindowsPage techGlobalMultipleWindowsPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalIFramesPage techGlobalIFramesPage;
    TechGlobalFileUploadPage techGlobalFileUploadPage;
    TechGlobalFileDownloadPage techGlobalFileDownloadPage;
    TechGlobalStaticTablesPage techGlobalStaticTablesPage;
    TechGlobalCalendarPage techGlobalCalendarPage;
    TechGlobalSortableTablesPage techGlobalSortableTablesPage;
    TechGlobalActionsPage techGlobalActionPage;
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("appURL"));
        techGlobalBasePage = new TechGlobalBasePage();
    }
    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
