package scripts;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalWaitsPage;
import utilities.Driver;
import utilities.Waiter;

public class TechGlobalWaitsTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage(){
        techGlobalWaitsPage = new TechGlobalWaitsPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
    }

    @Test(priority = 1, description = "Validation red box is visible")
    public void validateRedBox(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(3);

        techGlobalWaitsPage.redBoxButton.click();
        techGlobalWaitsPage.blueBoxButton.click();

        Assert.assertTrue(techGlobalWaitsPage.redBox.isDisplayed());

        Waiter.waitForVisibilityOfElement(techGlobalWaitsPage.blueBox, 60);
        Assert.assertTrue(techGlobalWaitsPage.blueBox.isDisplayed());

    }
}
