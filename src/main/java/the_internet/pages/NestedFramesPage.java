package the_internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import the_internet.core.BasePage;

import java.util.List;

public class NestedFramesPage extends BasePage {


    public NestedFramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(tagName = "frame")
    List<WebElement> frames;

    public NestedFramesPage getListOfFrames() {
        // Получает количество фреймов в основном документе
        int numberOfFrames = ((Long) js.executeScript("return window.length")).intValue();
        System.out.println("Number of frames on the main page: [" + numberOfFrames + "]");

        if (frames == null || frames.isEmpty()) {
            System.out.println("No frames found using @FindBy");
            return this;
        }

        // Выводит информацию о фреймах в основном документе
        for (WebElement frame : frames) {
            String frameName = frame.getAttribute("name");
            String frameSRC = frame.getAttribute("src");
            System.out.println("Frame found - NAME: [" + (frameName != null ? frameName : "No NAME") + "], SRC: [" + (frameSRC != null ? frameSRC : "No SRC") + "]");
        }

        // Заходит внутрь frame-top и ищет вложенные фреймы
        try {
            driver.switchTo().frame("frame-top");  // Переключаемся в главный контейнер
            List<WebElement> nestedFrames = driver.findElements(By.tagName("frame"));
            System.out.println("Number of nested frames inside 'frame-top': [" + nestedFrames.size() + "]");

            for (WebElement nestedFrame : nestedFrames) {
                String nestedFrameName = nestedFrame.getAttribute("name");
                String nestedFrameSRC = nestedFrame.getAttribute("src");
                System.out.println("Nested Frame found - NAME: [" + (nestedFrameName != null ? nestedFrameName : "No NAME") + "], SRC: [" + (nestedFrameSRC != null ? nestedFrameSRC : "No SRC") + "]");
            }
        } catch (Exception e) {
            System.out.println("Error while switching to frame-top: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent(); // Возвращается в основной документ
        }

        return this;
    }
    public NestedFramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(tagName = "body")
    WebElement bottom;
    public NestedFramesPage verifyFrameText(String text) {
        shouldHaveText(bottom,text, 5000);
        return this;
    }
}

