package mentoring.task4_ConfigApp.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class ConfigAppHomePage extends BasePage {

    @Name("Link for 5021 client")
    @FindBy(linkText = "Test Client AT Nominator")
    private Link client5021Link;

    public ConfigAppHomePage(WebDriver driver) {
        super(driver);
    }

    public CoreSettingsPage clickClientLink() {
        waitUntilVisible(client5021Link);
        client5021Link.click();
        return new CoreSettingsPage(getWebDriver());
    }
}
