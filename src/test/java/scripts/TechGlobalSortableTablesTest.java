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
import java.util.TreeSet;
import java.util.stream.IntStream;

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

    @Test(priority = 1, description = "Sort table by acs and valoidate it is sorted bt quantity")
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
}
