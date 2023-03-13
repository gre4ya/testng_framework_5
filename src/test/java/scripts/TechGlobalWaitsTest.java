package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalWaitsPage;
import utilities.Waiter;

public class TechGlobalWaitsTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage(){
        techGlobalWaitsPage = new TechGlobalWaitsPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(3);
    }
    @Test(priority = 1, description = "Validation red box is visible", enabled = false)
    public void validateRedBox(){
        techGlobalWaitsPage.redBoxButton.click();
        Assert.assertTrue(techGlobalWaitsPage.redBox.isDisplayed());
        //Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException e);
    }
    @Test(priority = 1, description = "Validation blue box is visible", enabled = false)
    public void validateBlueBox(){
        techGlobalWaitsPage.blueBoxButton.click();
        Waiter.waitForVisibilityOfElement(techGlobalWaitsPage.blueBox, 60);
        Assert.assertTrue(techGlobalWaitsPage.blueBox.isDisplayed());
    }
}
