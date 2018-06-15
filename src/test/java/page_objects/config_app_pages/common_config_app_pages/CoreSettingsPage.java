package page_objects.config_app_pages.common_config_app_pages;

import page_objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import page_objects.config_app_pages.award_details_file_pages.AwardDetailsConfigurationPage;
import page_objects.config_app_pages.award_program_pages.AwardProgramsPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class CoreSettingsPage extends BasePage {

    @Name("Awards section")
    @FindBy(xpath = "//span[contains(@class, 'ygtvlabel') and text() = 'Awards']")
    private TextBlock awardSectionTextBlock;

    @Name("Award Programs sub-section")
    @FindBy(xpath = "//a[contains(@class, 'ygtvlabel') and text() = 'Award Programs']")
    private TextBlock awardProgramTextBlock;

    @Name("Awards Details File section")
    @FindBy(xpath = "//span[contains(@class, 'ygtvlabel') and text() = 'Award Details File']")
    private TextBlock awardDetailsFileTextBlock;

    @Name("Award Details Configuration sub-section")
    @FindBy(xpath = "//a[contains(@class, 'ygtvlabel') and text() = 'Award Details Configuration']")
    private TextBlock awardDetailsConfigurationTextBlock;

    public CoreSettingsPage(WebDriver driver) {
        super(driver);
    }

    public AwardProgramsPage moveToAwardPrograms() {
        awardSectionTextBlock.click();
        awardProgramTextBlock.click();
        return new AwardProgramsPage(getWebDriver());
    }

    public AwardDetailsConfigurationPage moveToAwardDetailsConfiguration() {
        awardDetailsFileTextBlock.click();
        awardDetailsConfigurationTextBlock.click();
        return new AwardDetailsConfigurationPage(getWebDriver());
    }
}
