package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalIFramesPage extends TechGlobalBasePage{
    public TechGlobalIFramesPage(){super();}
    @FindBy(css = "#name_form > p")
    public WebElement inputHeader;
    @FindBy(id = "form_frame")
    public WebElement iFrame;
    @FindBy(tagName = "input")
    public List<WebElement> input;
    @FindBy(id = "submit")
    public WebElement submitButton;
    @FindBy(id = "result")
    public WebElement result;



}
