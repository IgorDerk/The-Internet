package the_internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import the_internet.core.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //* FormAuthentication
    @FindBy(linkText = "Form Authentication")
    WebElement formAuthentication;

    public void getFormAuthentication() {

        scrollTo(100);
        click(formAuthentication);
//        clickWithJS(formAuthentication, 0, 0);

    }


    //* NestedFrames
    @FindBy(linkText = "Nested Frames")
    WebElement nestedFrames;

    public void getNestedFrames() {
        scrollTo(600);
        click(nestedFrames);
    }
}
