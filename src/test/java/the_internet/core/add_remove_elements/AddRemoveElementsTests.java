package the_internet.core.add_remove_elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import the_internet.core.TestBase;
import the_internet.pages.AddRemovePage;

import static the_internet.pages.HomePage.HOME_PAGE_URL;

public class AddRemoveElementsTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/add_remove_elements/");
    }

    @Test
    public void AddElementDeletePositiveTests() {
        new AddRemovePage(app.driver, app.wait)
                .clickOnAddElement()
                .verifyAddedElementDelete("Delete")
        ;
    }

    @Test
    public void DeleteElementDeletePositiveTests() {
        new AddRemovePage(app.driver, app.wait)
                .clickOnAddElement()
                .clickOnDeleteElement()
                .verifyDeletedElementDelete()
        ;

    }
}
