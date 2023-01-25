package testng_knowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class _06_DataProvider {

    @Test(dataProvider = "searchData")
    public void validateSearchResult(String data){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(data + Keys.ENTER);

        WebElement resultStatics = driver.findElement(By.id("result-stats"));
        String result = resultStatics.getText();

        Assert.assertTrue(Long.parseLong(result.substring(result.indexOf(" ") + 1,
                            result.indexOf("results") - 1).replace(",", "")) > 0);

        Driver.quitDriver();
    }

    @DataProvider
    public Object[] searchData(){
        return new Object[]{"Phone", "Spoon", "AirPods", "Mouse", "Pen"};
    }


}
