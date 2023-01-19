package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCheckBoxPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalCheckBoxTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCheckBoxPage = new TechGlobalCheckBoxPage();
    }

    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Checkboxes" card
    Validate "Apple" and "Microsoft" checkboxes are displayed, enabled and not selected
    Select both and validate they are both selected
    Deselect bpth and validate they are deselected
    */

    @Test(priority = 1, description = "Validate Checkboxes (1)")
    public void ValidateCheckboxes1(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(6);
        for (int i = 0; i < techGlobalCheckBoxPage.checkBoxLabel1.size(); i++) {
            Assert.assertTrue(techGlobalCheckBoxPage.checkBoxInput1.get(i).isDisplayed());
            Assert.assertFalse(techGlobalCheckBoxPage.checkBoxInput1.get(i).isSelected());
            Assert.assertTrue(techGlobalCheckBoxPage.checkBoxInput1.get(i).isEnabled());
        }
        for (int i = 0; i < techGlobalCheckBoxPage.checkBoxLabel1.size(); i++) {
            techGlobalCheckBoxPage.checkBoxLabel1.get(i).click();
            Waiter.pause(1);
            Assert.assertTrue(techGlobalCheckBoxPage.checkBoxInput1.get(i).isSelected());
        }
        for (int i = 0; i < techGlobalCheckBoxPage.checkBoxLabel1.size(); i++) {
            techGlobalCheckBoxPage.checkBoxLabel1.get(i).click();
            Waiter.pause(1);
            Assert.assertFalse(techGlobalCheckBoxPage.checkBoxInput1.get(i).isSelected());
        }
    }

    @Test(priority = 1, description = "Validate Checkboxes (2)")
    public void ValidateCheckboxes2(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(6);

        techGlobalCheckBoxPage.checkBoxInput2.forEach(box -> {
            Assert.assertTrue(box.isDisplayed());
            Assert.assertFalse(box.isSelected());
            Assert.assertTrue(box.isEnabled());
        });

//        for (int i = 0; i < techGlobalCheckBoxPage.checkBoxInput2.size(); i++) {
//            Assert.assertTrue(techGlobalCheckBoxPage.checkBoxInput2.get(i).isDisplayed());
//            Assert.assertFalse(techGlobalCheckBoxPage.checkBoxInput2.get(i).isSelected());
//            Assert.assertTrue(techGlobalCheckBoxPage.checkBoxInput2.get(i).isEnabled());
//        }


        for (int i = 0; i < techGlobalCheckBoxPage.checkBoxInput2.size(); i++) {
            techGlobalCheckBoxPage.checkBoxLabel2.get(i).click();
            Waiter.pause(1);
            Assert.assertTrue(techGlobalCheckBoxPage.checkBoxInput2.get(i).isSelected());
        }
        for (int i = 0; i < techGlobalCheckBoxPage.checkBoxInput2.size(); i++) {
            techGlobalCheckBoxPage.checkBoxLabel2.get(i).click();
            Waiter.pause(1);
            Assert.assertFalse(techGlobalCheckBoxPage.checkBoxInput2.get(i).isSelected());
        }
    }
}
