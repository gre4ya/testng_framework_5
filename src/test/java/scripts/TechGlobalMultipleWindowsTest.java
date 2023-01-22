package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalMultipleWindowsPage;
import utilities.Waiter;

public class TechGlobalMultipleWindowsTest  extends TechGlobalBase{
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalMultipleWindowsPage = new TechGlobalMultipleWindowsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Multiple Windows");
    }
    @Test(priority = 1, description = "Validate the Apple link")
    public void validateTheAppleLink(){
        Waiter.pause(2);
        techGlobalMultipleWindowsPage.links.get(0).click();
        Waiter.pause(2);
        Assert.assertEquals(driver.getTitle(), "Apple");
    }
}
