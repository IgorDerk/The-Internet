package internet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import internet.core.TestBase;
import internet.pages.KeyPressPage;

import static internet.pages.HomePage.HOME_PAGE_URL;

public class KeyPressesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.driver.get(HOME_PAGE_URL + "/key_presses");
    }

    @Test
    public void keyPressPositiveTest() {
        String letter = "a";
        new KeyPressPage(app.driver, app.wait)
                .pressKey(letter)
                .verifyPressedKey(letter)
        ;
    }

}
