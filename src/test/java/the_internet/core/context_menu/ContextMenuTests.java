package the_internet.core.context_menu;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import the_internet.core.TestBase;
import the_internet.pages.ContextMenuPage;

import static the_internet.pages.HomePage.HOME_PAGE_URL;

public class ContextMenuTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/context_menu");
    }

    @Test
    public void rightClickOnBoxAndAlertPositiveTest(){
        new ContextMenuPage(app.driver,app.wait)
                .rightClickOnBox()
                .verifyAlertText("You selected a context menu")
        ;
    }
}
