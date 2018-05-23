package mentoring.task2_PayrollJob.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;

public class SchedulerConsolePage extends BasePage {

    @Name("Link to Main Menu in Scheduler Console Page")
    @FindBy(css = "a[href='/gf-scheduler-console/']")
    private Link mainMenuLink;

    @Name("Payroll Run button")
    @FindBy(xpath = "//a[(text()='Globoforce--Payroll Job Manual')]/../following-sibling::td/button[text()=\"Run\"]")
    private Button payrollRunButton;

    @Name("Result message about payroll job run")
    @FindBy(xpath = "//a[(text()='Globoforce--Payroll Job Manual')]/../following-sibling::td/a")
    private Link payrollResultMessage;

    public SchedulerConsolePage(WebDriver driver) {
        super(driver);
    }

    public String getMainMenuLinkText() {
        return mainMenuLink.getText();
    }

    public PayrollJobSectionPage openPayrollJobSectionPage() {
        payrollRunButton.click();
        return new PayrollJobSectionPage(webdriver);
    }

    public String getPayrollResultMessageText() {
        return payrollResultMessage.getText();
    }

}
