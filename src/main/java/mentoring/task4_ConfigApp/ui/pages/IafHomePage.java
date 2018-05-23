package mentoring.task4_ConfigApp.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class IafHomePage extends BasePage {

    @Name("Application DDL Name")
    @FindBy(className = "drop")
    private TextBlock otherApplicationTextBlock;

    @Name("ConfigApp link")
    @FindBy(linkText = "Config")
    private Link configAppLink;

    public IafHomePage(WebDriver driver) {
        super(driver);
    }

    public ConfigAppHomePage openConfigApp() {
        Actions action = new Actions(getWebDriver());
        action.moveToElement(otherApplicationTextBlock.getWrappedElement()).click().perform();
        waitUntilVisible(configAppLink);
        action.moveToElement(configAppLink.getWrappedElement()).click().perform();
        return new ConfigAppHomePage(getWebDriver());
    }
}
