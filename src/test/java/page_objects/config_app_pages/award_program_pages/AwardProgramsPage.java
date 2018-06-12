package page_objects.config_app_pages.award_program_pages;

import page_objects.BasePage;
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
                .moveToElement(serviceAnniversariesAwardProgram.getWrappedElement(), -1, 0)
                .pause(2000)
                .release(testclient5021AwardProgram.getWrappedElement())
                .pause(500)
                .build()
                .perform();
        return this;
    }
}
