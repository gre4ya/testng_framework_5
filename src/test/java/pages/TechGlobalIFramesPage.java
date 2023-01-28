package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalIFramesPage extends TechGlobalBasePage{
    public TechGlobalIFramesPage(){super();}
    @FindBy(css = "#name_form > p")
    public WebElement inputHeader;
    @FindBy(css = "#form_frame")
    public WebElement iFrame;
    @FindBy(id = "first_name")
    public WebElement firstNameInput;
    @FindBy(id = "last_name")
    public WebElement lastNameInput;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "result")
    public WebElement result;


}
