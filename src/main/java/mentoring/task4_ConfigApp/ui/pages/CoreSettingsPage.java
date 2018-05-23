package mentoring.task4_ConfigApp.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class CoreSettingsPage extends BasePage {

    @Name("Awards section")
    @FindBy(xpath = "//span[contains(@class, 'ygtvlabel') and text() = 'Awards']")
    private TextBlock awardSectionTextBlock;

    @Name("Award Programs section")
    @FindBy(xpath = "//a[contains(@class, 'ygtvlabel') and text() = 'Award Programs']")
    private TextBlock awardProgramTextBlock;

    public CoreSettingsPage(WebDriver driver) {
        super(driver);
    }

    public AwardProgramsPage moveToAwardPrograms() {
        awardSectionTextBlock.click();
        awardProgramTextBlock.click();
        return new AwardProgramsPage(getWebDriver());
    }
}
