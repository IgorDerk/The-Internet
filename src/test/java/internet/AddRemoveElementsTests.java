package internet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import internet.core.TestBase;
import internet.pages.AddRemovePage;

import static internet.pages.HomePage.HOME_PAGE_URL;

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
