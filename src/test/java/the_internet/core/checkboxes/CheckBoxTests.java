package the_internet.core.checkboxes;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import the_internet.core.TestBase;
import the_internet.pages.CheckBoxPage;

import static the_internet.pages.HomePage.HOME_PAGE_URL;

public class CheckBoxTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/checkboxes");
    }

    @Test
    public void printCheckBoxPositiveTest() {
        new CheckBoxPage(app.driver, app.wait)
                .printCheckBox()
        ;
    }

    @Test
    public void  selectCheckboxByTextPositiveTest(){
        String checkBoxName = "checkbox 1";
        new CheckBoxPage(app.driver,app.wait)
                .selectCheckboxByText(checkBoxName)
                .verifyCheckbox(checkBoxName)
        ;
    }

    @Test
    public void  selectCheckboxByTextWithActionsPositiveTest(){
        String checkBoxName = "checkbox 1";
        new CheckBoxPage(app.driver,app.wait)
                .selectCheckboxByTextWithActions(checkBoxName)
                .verifyCheckbox(checkBoxName)
        ;
    }

    @Test
    public void  selectCheckboxByTextWithRobotPositiveTest(){
        String checkBoxName = "checkbox 1";
        new CheckBoxPage(app.driver,app.wait)
                .selectCheckboxByTextWithRobot(checkBoxName)
                .verifyCheckbox(checkBoxName)
        ;
    }

}
