package the_internet.core.drop_down;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import the_internet.core.TestBase;
import the_internet.pages.DropdownPage;

import static the_internet.pages.HomePage.HOME_PAGE_URL;

public class DropDownTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/dropdown");
    }

    @Test
    public void selectDropdownOptionByNamePositiveTest() {
        String option = "Option 1";
        new DropdownPage(app.driver,app.wait)
                .selectOptionByText(option)
                .verifySelectedOption(option)
        ;
    }

    @Test
    public void selectDropdownOptionByValuePositiveTest() {
        String option = "2";
        new DropdownPage(app.driver,app.wait)
                .selectOptionByValue(option)
                .verifySelectedOption(option)
        ;
    }

    @Test
    public void selectDropdownOptionByIndexPositiveTest() {
        int index = 2;
        String option = "Option " + index;
        new DropdownPage(app.driver,app.wait)
                .selectOptionByIndex(index)
                .verifySelectedOption(option)
        ;
    }

    @Test
    public void selectDropdownOptionByIndexDefaultPositiveTest() {
        new DropdownPage(app.driver, app.wait)
//                .selectOptionByIndex(0)
                .verifySelectedOption("Please select an option")
        ;
    }



}
