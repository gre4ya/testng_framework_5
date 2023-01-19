package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalRadioButtonsPage;

public class TechGlobalRadioButtonsTest extends TechGlobalBase{
    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Radio Buttons" card
    Validate "Java", "JavaScript" and "C#" radio buttons are displayed, enabled and not selected
    Select "Java" and validate it is selected but the other 2 are deselected
    Select "JavaScript" validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalRadioButtonsPage = new TechGlobalRadioButtonsPage();
    }

    @Test(priority = 1, description = "Validate Tech Global Language Radio Buttons (1)")
    public void languageRadioButtons1(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);

        for (int i = 0; i < techGlobalRadioButtonsPage.radioButtonsInput1.size(); i++) {
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsLabel1.get(i).isDisplayed());
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsLabel1.get(i).isEnabled());
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput1.get(i).isSelected());
        }
    }
    @Test
    public void javaRadioButtonValidation(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);
        techGlobalRadioButtonsPage.radioButtonsLabel1.get(0).click();

        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsInput1.get(0).isSelected());

        for (int i = 1; i < techGlobalRadioButtonsPage.radioButtonsInput1.size(); i++) {
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput1.get(i).isSelected());
        }

        techGlobalRadioButtonsPage.radioButtonsLabel1.get(1).click();

        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsInput1.get(1).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput1.get(0).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput1.get(2).isSelected());
    }

    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Radio Buttons" card
    Validate "Selenium", "Cypress" and "Playwright" radio buttons are displayed, enabled and not selected
    Select "Cypress" and validate it is selected but the other 2 are deselected
    Select "Playwright" validate it is selected but the other 2 are deselected
     */

    @Test(priority = 2, description = "Validate Tech Global Language Radio Buttons (2)")
    public void languageRadioButtons2(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);

        for (int i = 0; i < techGlobalRadioButtonsPage.radioButtonsInput2.size(); i++) {
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsLabel2.get(i).isDisplayed());
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsLabel2.get(i).isEnabled());
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput2.get(i).isSelected());
        }

        techGlobalRadioButtonsPage.radioButtonsLabel2.get(1).click();
        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsInput2.get(1).isSelected());

        for (int i = 0; i < techGlobalRadioButtonsPage.radioButtonsInput2.size(); i++) {
            if(i == 1) continue;
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput2.get(i).isSelected());
        }

        techGlobalRadioButtonsPage.radioButtonsLabel2.get(2).click();
        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsInput2.get(2).isSelected());

        for (int i = 0; i < techGlobalRadioButtonsPage.radioButtonsInput2.size() - 1; i++) {
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput2.get(i).isSelected());
        }

    }
}
