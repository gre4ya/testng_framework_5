package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalJavaExercisesHomePage extends TechGlobalBasePage{
    public TechGlobalJavaExercisesHomePage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = "div[class^='Card_cards']")
    public List<WebElement> cards;

    public void getJavaExercisesPage(){
        headerDropdown.click();
        headerDropDownOptions.get(2).click();
    }

}
