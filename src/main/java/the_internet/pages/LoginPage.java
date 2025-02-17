package the_internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import the_internet.core.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement userPassword;

    public LoginPage enterPersonalData(String name, String password) {
        type(userName, name);
        type(userPassword, password);
        return this;
    }

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    public SecurePage clickOnLoginButton() {
        click(loginButton);
        return new SecurePage(driver, wait);
    }


}
