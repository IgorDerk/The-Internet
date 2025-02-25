package internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import internet.core.BasePage;

public class AddRemovePage extends BasePage {
    public AddRemovePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//button[.='Add Element']")
    WebElement addElement;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement delete;

    public AddRemovePage clickOnAddElement() {
        click(addElement);
        wait.until(ExpectedConditions.visibilityOf(delete));

        return this;
    }

    public AddRemovePage verifyAddedElementDelete(String text) {
        shouldHaveText(delete, text, 2000);
        return this;
    }

    public AddRemovePage clickOnDeleteElement() {
        wait.until(ExpectedConditions.elementToBeClickable(delete));
        click(delete);
        return this;
    }

    public AddRemovePage verifyDeletedElementDelete() {
        wait.until(ExpectedConditions.invisibilityOf(delete));
        Assert.assertFalse(isElementPresent(delete));
        return this;
    }
}
