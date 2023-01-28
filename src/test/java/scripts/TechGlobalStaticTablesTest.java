package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalStaticTablesPage;

import java.util.stream.IntStream;

public class TechGlobalStaticTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalStaticTablesPage = new TechGlobalStaticTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Static Tables");
    }
    /**
     TEST 1
     Verify the headers of the table
     Go to https://techglobal-training.netlify.app/
     Click on “Practices” dropdown in the header
     Select the “Frontend Testing” option
     Click on the “Static Tables” card
     Check that the headers of the table are “Rank”, “Company”, “Employees”, and “Country”
     Verify the rows of the table
     */
    @Test(priority = 1, description = "")
    public void validateStaticTables(){
        String[] headers = {"Rank", "Company", "Employees", "Country"};
        IntStream.range(0, headers.length).forEach(i ->
                Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), headers[i]));
    }

}
