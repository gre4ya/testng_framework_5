package scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;
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
        Assert.assertEquals(techGlobalActionPage.clickBox.getText(), "Click on me");

        Assert.assertTrue(techGlobalActionPage.rightClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.rightClickBox.isEnabled());
        Assert.assertEquals(techGlobalActionPage.rightClickBox.getText(), "Right-Click on me");

        Assert.assertTrue(techGlobalActionPage.doubleClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.doubleClickBox.isEnabled());
        Assert.assertEquals(techGlobalActionPage.doubleClickBox.getText(), "Double-Click on me");

        actions.moveToElement(techGlobalActionPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionPage.clickResult.getText(),
                "You clicked on a button!");

        actions.moveToElement(techGlobalActionPage.rightClickBox).contextClick().perform();
        Assert.assertEquals(techGlobalActionPage.rightClickResult.getText(),
                "You right-clicked on a button!");

        actions.moveToElement(techGlobalActionPage.doubleClickBox).doubleClick().perform();
        Assert.assertEquals(techGlobalActionPage.doubleClickResult.getText(),
                "You double-clicked on a button!");
    }

    /**
     TEST2
     Go to https://techglobal-training.netlify.app/
     Click on the "Practices" dropdown in the header
     Select the "Frontend Testing" option from the dropdown menu
     Click on the "Actions" card
     Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     Verify that a message appears next to the  web element stating "An element dropped here!"
     */
    @Test(priority = 2, description = "")
    public void validateDragAndDropAction(){
        Assert.assertTrue(techGlobalActionPage.dragMeBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.dragMeBox.isEnabled());
        Assert.assertEquals(techGlobalActionPage.dragMeBox.getText(), "Drag Me");

        Assert.assertTrue(techGlobalActionPage.dropHereBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.dropHereBox.isEnabled());
        Assert.assertEquals(techGlobalActionPage.dropHereBox.getText(), "Drop Here");


        actions.moveToElement(techGlobalActionPage.dragMeBox).clickAndHold().moveToElement(techGlobalActionPage.dropHereBox).release().perform();
        Waiter.pause(2);
        Assert.assertEquals(techGlobalActionPage.dropHereResult.getText(),"An element dropped here!");


    }
}
