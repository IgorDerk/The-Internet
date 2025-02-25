package internet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.LoginPage;

public class LoginTests extends TestBase {
    String expectedLoggedText = "You logged into a secure area!";
    String expectedLoggedOutText = "You logged out of the secure area!";
    String expectedUsernameIsInvalid = "Your username is invalid!";


    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getFormAuthentication();

    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData("tomsmith", "SuperSecretPassword!")
                .clickOnLoginButton()
                .verifyLoggedUser(expectedLoggedText)
                .clickLogOutButton()
                .verifyLoggedOutUser(expectedLoggedOutText)
        ;
    }

    @Test
    @Parameters({"userName", "password"})
    public void loginPositiveParameterTest(String userName, String password) {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(userName, password)
                .clickOnLoginButton()
                .verifyLoggedUser(expectedLoggedText)
                .clickLogOutButton()
                .verifyLoggedOutUser(expectedLoggedOutText)
        ;
    }

    @DataProvider(name = "invalidUsernameAndPassword")
    public Object[][] getInvalidUsernameAndPassword() {
        return new Object[][]{
                {"user1", "wrongPass"},
                {"", "password123"},
                {"user2", ""},
                {"", ""}
        };
    }

    @Test(dataProvider = "invalidUsernameAndPassword")
    public void loginNegativeTest(String username, String password) {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(username, password)
                .clickOnLoginButton()
                .verifyInvalidUser(expectedUsernameIsInvalid)
        ;
    }


}

