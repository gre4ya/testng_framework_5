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

        //Before clicking on Apple Link
        // 1 window/tab

        String mainWindow = driver.getWindowHandle();
        techGlobalMultipleWindowsPage.links.get(0).click();

        // 2 windows/tabs

        for (String windowID : driver.getWindowHandles()) {
            if(!windowID.equals(mainWindow)) {
                driver.switchTo().window(windowID);
                break;
            }

        }
        Assert.assertEquals(driver.getTitle(), "Apple");
        driver.close();

        // Go back to TechGlobal page and validate URL

        driver.switchTo().window(mainWindow);

       Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));
    }
    @Test(priority = 2, description = "Validate link URLs")
    public void validateLinkURLs(){
        String mainWindow = driver.getWindowHandle();
        String[] urls = {
                "https://www.apple.com/",
                "https://www.microsoft.com/en-us/",
                "https://www.tesla.com/"
                };
        for (int i = 0; i < techGlobalMultipleWindowsPage.links.size(); i++) {
                techGlobalMultipleWindowsPage.links.get(i).click();
            for (String windowID : driver.getWindowHandles()) {
                if(!windowID.equals(mainWindow)){
                    driver.switchTo().window(windowID);
                    break;
                }
            }
            Assert.assertEquals(driver.getCurrentUrl(),urls[i]);

            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
