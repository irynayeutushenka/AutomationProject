package mentoring.task4_ConfigApp.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class AwardProgramsPage extends BasePage {

    @Name("Service Anniversaries Award Program")
    @FindBy(xpath = "//a[text() = 'Service Anniversaries']")
    private HtmlElement serviceAnniversariesAwardProgram;

    @Name("testclient5021 Award Program")
    @FindBy(xpath = "//a[text() = 'testclient5021 program']")
    private HtmlElement testclient5021AwardProgram;

    public AwardProgramsPage(WebDriver driver) {
        super(driver);
    }

    public AwardProgramsPage moveAwardProgram() {

        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(testclient5021AwardProgram.getWrappedElement(), -5, 0)
                .clickAndHold()
                .pause(500)
                .moveToElement(serviceAnniversariesAwardProgram.getWrappedElement(), -1, 10)
                .pause(2000)
                .release(testclient5021AwardProgram.getWrappedElement())
                .pause(500)
                .build()
                .perform();
        return this;
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
