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

    @Test(priority = 1, description = "Va")
    public void languageRadioButtons(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);

        for (int i = 0; i < techGlobalRadioButtonsPage.radioButtonsInput.size(); i++) {
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsLabel.get(i).isEnabled());
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput.get(i).isSelected());
        }
    }
    @Test
    public void javaRadioButtonValidation(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(5);
        techGlobalRadioButtonsPage.radioButtonsLabel.get(0).click();

        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsInput.get(0).isSelected());

        for (int i = 1; i < techGlobalRadioButtonsPage.radioButtonsInput.size(); i++) {
            Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput.get(i).isSelected());
        }

        techGlobalRadioButtonsPage.radioButtonsLabel.get(1).click();

        Assert.assertTrue(techGlobalRadioButtonsPage.radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput.get(0).isSelected());
        Assert.assertFalse(techGlobalRadioButtonsPage.radioButtonsInput.get(2).isSelected());

    }
}
