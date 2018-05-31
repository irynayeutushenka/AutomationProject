package pageObjects.configAppPages.CommonConfigAppPages;

import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import static utilities.Waiters.waitUntilVisible;

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
        waitUntilVisible(getWebDriver(), configAppLink);
        action.moveToElement(configAppLink.getWrappedElement()).click().perform();
        return new ConfigAppHomePage(getWebDriver());
    }
}
