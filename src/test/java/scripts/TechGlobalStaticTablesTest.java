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
    @Test(priority = 1)
    public void validateStaticTablesHeader(){
        String[] headers = {"Rank", "Company", "Employees", "Country"};
        IntStream.range(0, headers.length).forEach(i ->
                Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), headers[i]));
    }

    /**
     TEST 2
     Go to https://techglobal-training.netlify.app/
     Click on “Practices” dropdown in the header
     Select the “Frontend Testing” option
     Click on the “Static Tables” card
     Check that first row of the table has the values “1", “Amazon”, “1,523,000", and “USA”
     Verify the columns of the table
     */
    @Test(priority = 2)
    public void validateStaticTablesRow1(){
        String[] row1 = {"1", "Amazon", "1,523,000", "USA"};
        IntStream.range(0, row1.length).forEach(i ->
                Assert.assertEquals(techGlobalStaticTablesPage.row1Elements.get(i).getText(), row1[i]));
    }

}
