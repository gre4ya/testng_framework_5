package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;

import java.util.stream.IntStream;

public class TechGlobalDropdownsTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");
    }

    @Test(priority = 1, description = "Select Delivery option")
    public void selectDeliveryOption(){
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                                              techGlobalDropdownsPage.deliveryDropdownOptions,
                                              "Delivery");
    }
    @Test(priority = 2, description = "Select iPhone 14 Pro Max option")
    public void selectProductOption(){
        //Select select = new Select(techGlobalDropdownsPage.productDropdown);
        //select.selectByVisibleText("iPhone 14 Pro Max");
        //select.selectByIndex(1);
        //select.deselectByValue("iPhone 14 Pro Max");
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown, "iPhone 14 Pro Max");
    }
    @Test(priority = 3, description = "Select Yellow option")
    public void selectColorOption(){
        //new Select(techGlobalDropdownsPage.colorDropdown).selectByVisibleText("Yellow");
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.colorDropdown, 1);
    }
    /**
    Go to TechGlobal Training app
    Select Frontend Testing from Practices Dropdown
    Select Dropdowns card
    Select "MacBook Pro 13" option from product dropdown
    Select "Silver" option from the color dropdown
    Select "Delivery" option from delivery dropdown
    Click on SUBMIT button
    Validate "Your Silver MacBook Pro 13 will be delivered to you." message
     */
    @Test(priority = 4, description = "Select MecBook Pro 13 option")
    public void selectMacBookOption(){
    DropdownHandler.selectByValue(techGlobalDropdownsPage.productDropdown, "MacBook Pro 13");
    DropdownHandler.selectByIndex(techGlobalDropdownsPage.colorDropdown, 3);
    DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                                          techGlobalDropdownsPage.deliveryDropdownOptions,
                                          "Delivery");
    techGlobalDropdownsPage.submitButton.click();
    Assert.assertEquals(techGlobalDropdownsPage.resultMessage.getText(),
            "Your Silver MacBook Pro 13 will be delivered to you.");
    }
}
