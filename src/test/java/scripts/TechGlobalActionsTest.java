package scripts;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.WindowHandler;

public class TechGlobalActionsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionPage = new TechGlobalActionsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
        actions = new Actions(driver);
    }

    /**
     TEST1
     Go to https://techglobal-training.netlify.app/
     Click on the "Practices" dropdown in the header
     Select the "Frontend Testing" option from the dropdown menu
     Click on the "Actions" card
     Verify that the user is redirected to the Actions page
     Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     Perform a click action on the first web element labeled as "Click on me"
     Verify that  message appears next of the element stating "You clicked on a button!"
     Perform a right click action on the second web element labeled as "Right-Click on me""
     Verify that  message appears next of the element stating "You right-clicked on a button!"
     Perform a double click action on the third web element labeled as "Double-Click on me"
     Verify that  message appears next of the element stating "You double-clicked on a button!"
     */
    @Test(priority = 1, description = "Click first 3 boxes and validate the result")
    public void clickActions(){
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://techglobal-training.netlify.app/frontend/actions");
        Assert.assertTrue(techGlobalActionPage.clickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.clickBox.isEnabled());
        Assert.assertTrue(techGlobalActionPage.clickBox.isSelected());

        Assert.assertTrue(techGlobalActionPage.rightClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.rightClickBox.isEnabled());
        Assert.assertTrue(techGlobalActionPage.rightClickBox.isSelected());

        Assert.assertTrue(techGlobalActionPage.doubleClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.doubleClickBox.isEnabled());
        Assert.assertTrue(techGlobalActionPage.doubleClickBox.isSelected());

        Assert.assertEquals(techGlobalActionPage.clickBox.getText(),
                "Click on me");
        Assert.assertEquals(techGlobalActionPage.rightClickBox.getText(),
                "Right-Click on me");
        Assert.assertEquals(techGlobalActionPage.doubleClickBox.getText(),
                "Double-Click on me");



        actions.moveToElement(techGlobalActionPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionPage.clickResult.getText(),
                "You clicked on a button!");

        actions.moveToElement(techGlobalActionPage.rightClickBox).click().perform();
        Assert.assertEquals(techGlobalActionPage.rightClickResult.getText(),
                "You right-clicked on a button!");

        actions.moveToElement(techGlobalActionPage.doubleClickBox).click().perform();
        Assert.assertEquals(techGlobalActionPage.doubleClickResult.getText(),
                "You double-clicked on a button!");



    }
}
