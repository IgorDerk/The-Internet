package the_internet.core.nested_frames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import the_internet.core.TestBase;
import the_internet.pages.HomePage;
import the_internet.pages.NestedFramesPage;

public class NestedFramesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getNestedFrames();
    }

    @Test
    public void nestedFramesPositiveTests() {
        new NestedFramesPage(app.driver, app.wait)
                .getListOfFrames();
        ;
    }

    @Test
    public void switchToFrameByIndexPositiveTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToFrameByIndex(1)
                .verifyFrameText("BOTTOM")
        ;


    }


}
