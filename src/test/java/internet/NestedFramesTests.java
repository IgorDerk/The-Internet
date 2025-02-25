package internet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.NestedFramesPage;

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
