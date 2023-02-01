package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;
import utilities.WindowHandler;

import java.time.Duration;

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
    @Test(priority = 2, description = "Drag and drop actions")
    public void validateDragAndDropAction(){
        Assert.assertTrue(techGlobalActionPage.dragMeBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.dragMeBox.isEnabled());
        Assert.assertEquals(techGlobalActionPage.dragMeBox.getText(), "Drag Me");

        Assert.assertTrue(techGlobalActionPage.dropHereBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.dropHereBox.isEnabled());
        Assert.assertEquals(techGlobalActionPage.dropHereBox.getText(), "Drop Here");

        actions.moveToElement(techGlobalActionPage.dragMeBox).clickAndHold()
               .moveToElement(techGlobalActionPage.dropHereBox).release().perform();
        Waiter.waitForVisibilityOfElement(techGlobalActionPage.dropHereResult, 5);
        Assert.assertEquals(techGlobalActionPage.dropHereResult.getText(),"An element dropped here!");
    }
    /**
     TEST3
     Go to https://techglobal-training.netlify.app/
     Click on the "Practices" dropdown in the header
     Select the "Frontend Testing" option from the dropdown menu
     Click on the "Actions" card
     Go to input box, and remove existing text inside
     Enter “Hello” to search input box
     Validate value attribute is “Hello”
     */
    @Test(priority = 3, description = "Keyboard actions")
    public void keyboardActions(){
        actions.moveToElement(techGlobalActionPage.inputBox).click();
        actions.keyDown(Keys.SHIFT)
                .sendKeys(techGlobalActionPage.inputBox, "h")
                .keyUp(Keys.SHIFT)
                .sendKeys("ello")
                .perform();
        Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"), "Hello");
    }
    /**
     TEST4
     Go to https://techglobal-training.netlify.app/
     Click on the "Practices" dropdown in the header
     Select the "Frontend Testing" option from the dropdown menu
     Click on the "Actions" card
     Go to input box, and remove existing text inside
     Enter “techglobal” to input box with uppercases
     Validate the value attribute for search input box is “TECHGLOBAL”
     Then, copy the text and paste again
     Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */
    @Test(priority = 4, description = "")
    public void validateKeyboardInput(){
        actions.keyDown(Keys.SHIFT)
                .sendKeys(techGlobalActionPage.inputBox, "techglobal")
                .keyUp(Keys.SHIFT).perform();
        Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"), "TECHGLOBAL");

        actions.moveToElement(techGlobalActionPage.inputBox)
                .keyDown(Keys.COMMAND).sendKeys("a").sendKeys("c")
                .keyUp(Keys.COMMAND)
                .keyDown(Keys.COMMAND).sendKeys("v").sendKeys("v").keyUp(Keys.COMMAND).perform();
        Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
    }
}
