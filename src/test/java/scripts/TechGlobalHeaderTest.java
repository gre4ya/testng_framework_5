package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;


public class TechGlobalHeaderTest extends TechGlobalBase{
    @Test
    public void validateTechGlobalHeaderDropdown(){
        WebElement headerDropdown = driver.findElement(By.id("dropdown-button"));
        Assert.assertTrue(headerDropdown.isDisplayed());
        Assert.assertEquals(headerDropdown.getText(), "Practices");
    }
    @Test
    public void validateTechGlobalHeaderDropdownOptions() {
        driver.findElement(By.id("dropdown-button")).click();
        List<WebElement> dropDownElements = driver.findElements(By.cssSelector(".dropdown-content a"));
        String[] dropDownElementsActual =
                {
                "Frontend Testing",
                "Backend Testing",
                "Java Exercises"
                };
        for (int i = 0; i < dropDownElements.size(); i++) {
            Assert.assertTrue(dropDownElements.get(i).isDisplayed());
            Assert.assertEquals(dropDownElements.get(i).getText(), dropDownElementsActual[i]);
        }
    }
}
