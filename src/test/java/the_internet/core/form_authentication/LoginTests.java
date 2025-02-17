package the_internet.core.form_authentication;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import the_internet.core.TestBase;
import the_internet.pages.HomePage;
import the_internet.pages.LoginPage;

public class LoginTests extends TestBase {
    String expectedText = "You logged into a secure area!";


    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getFormAuthentication();

    }


    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData("tomsmith", "SuperSecretPassword!")
                .clickOnLoginButton()
                .verifyLoggedUser(expectedText);
    }
}
