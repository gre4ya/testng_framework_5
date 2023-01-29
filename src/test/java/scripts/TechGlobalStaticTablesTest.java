package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalStaticTablesPage;
import utilities.TableData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    @Test(priority = 1, description = "Validate Header Table text")
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
    @Test(priority = 2, description = "Validate Row 1 text")
    public void validateStaticTablesRow1(){
        String[] row1 = {"1", "Amazon", "1,523,000", "USA"};
        List<WebElement> tableRow = TableData.getTableRow(driver, 1);
        IntStream.range(0, row1.length).forEach(i -> Assert.assertEquals(tableRow.get(i).getText(), row1[i]));
    }
    /**
     TEST 3
     Go to https://techglobal-training.netlify.app/
     Click on “Practices” dropdown in the header
     Select the “Frontend Testing” option
     Click on the “Static Tables” card
     Check that the “Country” column of the table has the values “USA”, “China”, “USA”, “USA”, “S. Korea”
     Verify the entire table
     */
    @Test(priority = 3, description = "Validate Column 4 text")
    public void validateStaticTableColumn4(){
        String[] column4Expected = {"USA", "China", "USA", "USA", "S. Korea"};
        List<WebElement> column4Actual = TableData.getTableColumn(driver, 4);
        IntStream.range(0, column4Actual.size()).forEach(i -> {
            System.out.println(column4Actual.get(i).getText());
            Assert.assertEquals(column4Actual.get(i).getText(), column4Expected[i]);
        });
    }
    @Test(priority = 4, description = "Validate all cells")
    public void validateAllCells(){
        List<List<WebElement>> tableData = techGlobalStaticTablesPage.getTaleData();
        List<List<String>> tableExpected = new ArrayList<>();
        tableExpected.add(Arrays.asList("1", "Amazon", "1,523,000", "USA"));
        tableExpected.add(Arrays.asList("2", "Alibaba", "245,700", "China"));
        tableExpected.add(Arrays.asList("3", "Microsoft", "221,000", "USA"));
        tableExpected.add(Arrays.asList("4", "Apple", "154,000", "USA"));
        tableExpected.add(Arrays.asList("5", "Samsung", "116,915", "S. Korea"));

        for (int i = 0; i < tableData.size(); i++) {
            for (int j = 0; j < tableData.get(i).size(); j++) {
                Assert.assertEquals(tableData.get(i).get(j).getText(), tableExpected.get(i).get(j));
            }
        }
    }
}
