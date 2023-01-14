package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TechGlobalHeaderTest extends TechGlobalBase{
    @Test(priority = 2)
    public void validateTechGlobalHeaderDropdown(){
        WebElement headerDropdown = driver.findElement(By.id("dropdown-button"));
        Assert.assertTrue(headerDropdown.isDisplayed());
        Assert.assertEquals(headerDropdown.getText(), "Practices");
    }
    @Test(priority = 1)
    public void validateTechGlobalHeaderDropdownOptions() {
        driver.findElement(By.id("dropdown-button")).click();
        List<WebElement> dropDownOptions = driver.findElements(By.cssSelector(".dropdown-content a"));
        String[] dropDownOptionsExpected =
                {
                "Frontend Testing",
                "Backend Testing",
                "Java Exercises"
                };
        for (int i = 0; i < dropDownOptions.size(); i++) {
            Assert.assertTrue(dropDownOptions.get(i).isDisplayed());
            Assert.assertTrue(dropDownOptions.get(i).isEnabled());
            Assert.assertEquals(dropDownOptions.get(i).getText(), dropDownOptionsExpected[i]);
        }
    }
}
