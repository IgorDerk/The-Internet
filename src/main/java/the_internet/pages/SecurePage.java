package the_internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import the_internet.core.BasePage;

public class SecurePage extends BasePage {
    public SecurePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "flash")
    WebElement secureFlashLogged;

    public SecurePage verifyLoggedUser(String expectedText) {

        Assert.assertTrue(secureFlashLogged.getText().contains(expectedText), "Текст не совпадает!");
        return new SecurePage(driver, wait);
    }


    @FindBy(xpath = "//i[contains(text(),'Logout')]")
    WebElement logoutButton;

    public LoginPage clickLogOutButton() {
//        click(loginButton);
        clickWithJS(logoutButton, 0, 0);
        return new LoginPage(driver, wait);
    }

    @FindBy(id = "flash")
    WebElement secureFlashUsernameIsInvalid;

    public void verifyInvalidUser(String expectedText) {
        System.out.println(secureFlashUsernameIsInvalid.getText());
        Assert.assertTrue(secureFlashUsernameIsInvalid.getText().contains(expectedText), "Текст не совпадает!");
    }

}
