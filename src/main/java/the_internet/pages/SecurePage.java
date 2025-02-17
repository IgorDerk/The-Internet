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
    WebElement secureFlash;

    public void verifyLoggedUser(String expectedText) {
        Assert.assertTrue(secureFlash.getText().contains(expectedText), "Текст не совпадает!");
    }
}
