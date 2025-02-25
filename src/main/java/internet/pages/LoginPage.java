package internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import internet.core.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement userPassword;

    public LoginPage enterPersonalData(String name, String password) {
//        type(userName, name);
//        type(userPassword, password);
        typeWithJS(userName, name,0,0);
        typeWithJS(userPassword, password,0,0);
        return this;
    }

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    public SecurePage clickOnLoginButton() {
//        click(loginButton);
        clickWithJS(loginButton, 0, 0);
        return new SecurePage(driver, wait);
    }

    @FindBy(id = "flash")
    WebElement secureFlashLoggedOut;

    public void verifyLoggedOutUser(String expectedText) {
        System.out.println(secureFlashLoggedOut.getText());
        Assert.assertTrue(secureFlashLoggedOut.getText().contains(expectedText), "Текст не совпадает!");
    }


}
