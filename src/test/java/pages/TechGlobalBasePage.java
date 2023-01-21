package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class TechGlobalBasePage {
    public TechGlobalBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "logo")
    public WebElement logo;
    @FindBy(id = "dropdown-button")
    public WebElement headerDropdown;
    @FindBy(css = "#dropdown-menu a")
    public List<WebElement> headerDropDownOptions;

    @FindBy(css = ".Footer_footer__kXlYa p")
    public List<WebElement> footerParagraphs;

    @FindBy(css = ".Footer_footer__kXlYa a")
    public List<WebElement> footerSocialLinks;


}
