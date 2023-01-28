package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TechGlobalFooterTest extends TechGlobalBase{

    @Test
    public void validateCorrectTextDisplayFooter(){
        String[] footerTextExpected =
                {
                "2860 S River Rd Suite 350, Des Plaines IL 60018",
                "© 2023 TechGlobal - All Rights Reserved"
                };

        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(techGlobalBasePage.footerParagraphs.get(i).isDisplayed());
            Assert.assertEquals(techGlobalBasePage.footerParagraphs.get(i).getText(), footerTextExpected[i]);
        }
    }
    @Test
    public void validateSocialLinksFooter(){
        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(techGlobalBasePage.footerSocialLinks.get(i).isDisplayed(),
                    "Social media links Display Validation in footer FAILED");
            Assert.assertTrue(techGlobalBasePage.footerSocialLinks.get(i).isEnabled(),
                    "Social media links Enable Validation in footer FAILED");
        }
    }

}
