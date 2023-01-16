package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalJavaExercisesHomePage;


public class TechGlobalJavaExercisesHomeTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage(){techGlobalJavaExercisesHomePage = new TechGlobalJavaExercisesHomePage();}

    @Test
    public void validateJavaExercisesCards(){
        techGlobalJavaExercisesHomePage.getJavaExercisesPage();

        String[] cardText =
                {
                        "Print Statements",
                        "Scanner Programs",
                        "Conditional Statements",
                        "Basic Methods",
                        "String Methods",
                        "Loops",
                        "Arrays",
                        "ArrayLists",
                        "Regex",
                        "Collections",
                        "Exercise-1",
                        "Exercise-2",
                        "Exercise-3",
                        "Exercise-4",
                        "Exercise-5",
                        "Exercise-6",
                        "Exercise-7",
                        "Exercise-8",
                        "Exercise-9",
                        "Exercise-10"
                };
        for (int i = 0; i < 20; i++) {
            Assert.assertTrue(techGlobalJavaExercisesHomePage.cards.get(i).isDisplayed());
            Assert.assertEquals(techGlobalJavaExercisesHomePage.cards.get(i).getText(), cardText[i]);
        }
    }
}
