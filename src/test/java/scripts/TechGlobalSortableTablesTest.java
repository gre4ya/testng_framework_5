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
    public ArrayList<Integer> addTableDataToList(int columnNumber){
        List<WebElement> columnElements = TableData.getTableColumn(driver, columnNumber);
        ArrayList<Integer> columnIntegerValues = new ArrayList<>();
        for (WebElement element : columnElements) {
            columnIntegerValues.add(Integer.parseInt(element.getText()));
        }
        return columnIntegerValues;
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
        ArrayList<Integer> columnValues = addTableDataToList(1);
        System.out.println(columnValues);
        for (int i = 0; i < columnValues.size() - 1; i++) {
            Assert.assertTrue(columnValues.get(i) <= columnValues.get(i + 1));
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
    @Test(priority = 2, description = "Sort table by desc and validate it is sorted bt quantity")
    public void validateSortDescByQuantity() {
        techGlobalSortableTablesPage.descByQuantity.click();
        ArrayList<Integer> columnValues = addTableDataToList(1);
        System.out.println(columnValues);
        for (int i = 0; i < columnValues.size() - 1; i++) {
            Assert.assertTrue(columnValues.get(i) >= columnValues.get(i + 1));
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
    @Test(priority = 3, description = "Sort table by asc and validate it is sorted bt price")
    public void validateSortAscByPrice() {
        techGlobalSortableTablesPage.ascByPrice.click();
        ArrayList<Integer> columnValues = addTableDataToList(3);
        System.out.println(columnValues);
        for (int i = 0; i < columnValues.size() - 1; i++) {
            Assert.assertTrue(columnValues.get(i) <= columnValues.get(i + 1));
        }
    }
    /**
     TEST4
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown in the header
     Select the "Frontend Testing" option
     Click on the "Sortable Tables" card
     Click on the Price sort button to toggle descending order
     Verify that the Price column of the table is sorted in descending order
     */
    @Test(priority = 4, description = "Sort table by desc and validate it is sorted bt price")
    public void validateSortDescByPrice() {
        techGlobalSortableTablesPage.descByPrice.click();
        ArrayList<Integer> columnValues = addTableDataToList(3);
        System.out.println(columnValues);
        for (int i = 0; i < columnValues.size() - 1; i++) {
            Assert.assertTrue(columnValues.get(i) >= columnValues.get(i + 1));
        }
    }
}
