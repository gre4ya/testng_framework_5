package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.TableData;
import utilities.TextHandler;

import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalDynamicTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dynamic Tables");
    }
    /**
    REGULAR MODAL AUTOMATION (this is not a JS alert)
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Dynamic Tables" card
    Click on the "ADD PRODUCT" button
    Validate the modal title equals "Add New Product"
     */
    @Test(priority = 1, description = "pop up validation")
    public void popupValidation(){techGlobalDynamicTablesPage.addProductButton.click();
       Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");
    }

    /**
     DYNAMIC TABLES
     TEST1
     Go to https://techglobal-training.netlify.app/
     Click on “Practices” dropdown in the header
     Select the “Frontend Testing” option
     Click on the “Dynamic Tables” card
     Click the “Add Product” button
     Enter “2” in the Quantity field
     Enter “Apple Watch” in the Product field
     Enter “500” in the Price $ field
     Click the “Submit” button
     Verify that a new row has been added to the table with the values “2”,
     “Apple Watch, “500” and the calculated Total $ value is “1,000"
     Verify that the Total $ value at the bottom of the table has been updated
     to reflect the total cost of all the products in the table, including the newly added one.
     */
    @Test(priority = 2, description = "Validate Dynamic Table")
    public void validateDynamicTable(){
        techGlobalDynamicTablesPage.addProductButton.click();

        /** store the current total amount before adding a new product and parse it to an int */
        int initialTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        /** validate that the modal card is displayed */
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");

        /** storing all the products in an array, so we can add it */
        String[] products = {"2", "Apple Watch", "500"};

        /** storing initial table row size and validate it is 3 */
        int initialTableSize = techGlobalDynamicTablesPage.tableRows.size();
        Assert.assertEquals(initialTableSize, 3);

        /** validate the total amount of the new product by multiplying quantity with price */
        int myProductTotal = Integer.parseInt(products[0]) * Integer.parseInt(products[2]);

        /** enter the values from the products array into the corresponding input fields */
        IntStream.range(0, products.length).forEach(i -> techGlobalDynamicTablesPage.productDetails.get(i).sendKeys(products[i]));

        /** submit the form to add the new product to our table */
        techGlobalDynamicTablesPage.submitButton.click();

        /** then validate that there are now 4 rows in the table */
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRows.size(), initialTableSize + 1);

        /**  get the total amount of the newly added product from the table */
        int productTotal = TextHandler.getInt(TableData.getTableRow(driver, 4).get(3).getText());

        /**  get the row of the table that you need to check */
        List<WebElement> tableRow = TableData.getTableRow(driver, 4);

        /**  validate that values in the table match the values from product array*/
        IntStream.range(0, tableRow.size() - 1).forEach(i -> Assert.assertEquals(tableRow.get(i).getText(), products[i]));

        /** validate that the total amount of the newly added product matches the calculated value */
        Assert.assertEquals(productTotal, myProductTotal);

        /** get the final total amount from the table */
        int newTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        /** calculate the expected total amount by adding the total of the newly added product to the initial total */
        int expectedTotal = initialTotal + productTotal;

        /** validate that the currant total matches expected total */
        Assert.assertEquals(newTotal, expectedTotal);

    }

}
