package scripts;

import org.testng.annotations.BeforeMethod;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalFrontendTestingHomePage;
public class TechGlobalAlertsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
    }


}
