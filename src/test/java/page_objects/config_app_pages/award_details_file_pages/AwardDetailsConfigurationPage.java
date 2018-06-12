package page_objects.config_app_pages.award_details_file_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import page_objects.BasePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import utilities.Waiters;

public class AwardDetailsConfigurationPage extends BasePage {

    public AwardDetailsConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Name("1st payroll group link")
    @FindBy(id = "edit_1")
    private Link firstPayrollGroupLink;

    public EditAwardDetailsConfigurationPage clickFirstPayrollGroupLink() {
        Waiters.waitUntilClickable(getWebDriver(), firstPayrollGroupLink);
        firstPayrollGroupLink.click();
        return new EditAwardDetailsConfigurationPage(getWebDriver());
    }
}
