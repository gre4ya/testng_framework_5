package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TechGlobalBasePage {
    WebDriver driver;
    public TechGlobalBasePage(){
        PageFactory.initElements(driver, this);
    }
}
