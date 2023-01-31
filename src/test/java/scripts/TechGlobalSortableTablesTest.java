package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalSortableTablesPage;
import utilities.TableData;

import java.util.ArrayList;
import java.util.List;

public class TechGlobalSortableTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalSortableTablesPage = new TechGlobalSortableTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Sortable Tables");
    }
    /**
     TEST1
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown in the header
     Select the "Frontend Testing" option
     Click on the "Sortable Tables" card
     Click on the Quantity sort button to toggle Ascending Order
     Verify that the Quantity column of the table is sorted in ascending order
     */

    @Test(priority = 1, description = "Sort table by acs and validate it is sorted bt quantity")
    public void validateSortAcsByQuantity(){
        techGlobalSortableTablesPage.ascByQuantity.click();
        List<WebElement> column1Elements = TableData.getTableColumn(driver, 1);
        ArrayList<Integer> column1IntegerValues = new ArrayList<>();
        for (WebElement element : column1Elements) {
            column1IntegerValues.add(Integer.parseInt(element.getText()));
        }
        for (int i = 1; i < column1IntegerValues.size(); i++) {
            Assert.assertTrue(column1IntegerValues.get(i) >= column1IntegerValues.get(i - 1));
        }
    }
    /**
     TEST2
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown in the header
     Select the "Frontend Testing" option
     Click on the "Sortable Tables" card
     Click on the Quantity sort button to toggle descending order
     Verify that the Quantity column of the table is sorted in descending order
     */
    @Test(priority = 1, description = "Sort table by desc and validate it is sorted bt quantity")
    public void validateSortDescByQuantity() {
        techGlobalSortableTablesPage.descByQuantity.click();
        List<WebElement> column2Elements = TableData.getTableColumn(driver, 1);
        ArrayList<Integer> column2IntegerValues = new ArrayList<>();
        for (WebElement element : column2Elements) {
            column2IntegerValues.add(Integer.parseInt(element.getText()));
        }
        for (int i = 0; i < column2IntegerValues.size() - 1; i++) {
            Assert.assertTrue(column2IntegerValues.get(i) >= column2IntegerValues.get(i + 1));
        }
    }


    /**
     TEST3
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown in the header
     Select the "Frontend Testing" option
     Click on the "Sortable Tables" card
     Click on the Price sort button to toggle Ascending Order
     Verify that the Price column of the table is sorted in ascending order
     */


    /**
     TEST4
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown in the header
     Select the "Frontend Testing" option
     Click on the "Sortable Tables" card
     Click on the Price sort button to toggle descending order
     Verify that the Price column of the table is sorted in descending order
     */
}
