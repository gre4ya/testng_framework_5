package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TechGlobalHeaderTest extends TechGlobalBase{
    @Test(priority = 2)
    public void validateTechGlobalHeaderDropdown(){
        Assert.assertTrue(techGlobalBasePage.headerDropdown.isDisplayed());
        Assert.assertEquals(techGlobalBasePage.headerDropdown.getText(), "Practices");
    }
    @Test(priority = 1)
    public void validateTechGlobalHeaderDropdownOptions() {
        techGlobalBasePage.headerDropdown.click();
        String[] dropDownOptionsExpected =
                {
                "Frontend Testing",
                "Backend Testing",
                "Java Exercises"
                };
        for (int i = 0; i < techGlobalBasePage.headerDropDownOptions.size(); i++) {
            Assert.assertTrue(techGlobalBasePage.headerDropDownOptions.get(i).isDisplayed());
            Assert.assertTrue(techGlobalBasePage.headerDropDownOptions.get(i).isEnabled());
            Assert.assertEquals(techGlobalBasePage.headerDropDownOptions.get(i).getText(), dropDownOptionsExpected[i]);
        }
    }
}
