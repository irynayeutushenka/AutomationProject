package pageObjects.payrollPages;

import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static utilities.Waiters.waitUntilVisible;

public class PayrollJobSectionPage extends BasePage {

    @Name("Client input field")
    @FindBy(name = "client")
    private TextInput clientIdInput;

    @Name("Date field")
    @FindBy(name = "date")
    private TextInput dateInput;

    @Name("Payroll input field")
    @FindBy(name = "payroll_group")
    private TextInput payrollGroupInput;

    @Name("Start job button")
    @FindBy(id = "start-job")
    private Button startJobButton;

    public PayrollJobSectionPage(WebDriver driver) {
        super(driver);
    }

    public SchedulerConsolePage runPayrollJobOnClientLevel(int clientId, String date) {
        waitUntilVisible(getWebDriver(), clientIdInput);
        clientIdInput.sendKeys(String.valueOf(clientId));
        dateInput.sendKeys(date);
        startJobButton.click();
        return new SchedulerConsolePage(getWebDriver());
    }

    public SchedulerConsolePage runPayrollJobOnPayrollGroupLevel(int clientId, String date, String payrollGroup) {
        waitUntilVisible(getWebDriver(), clientIdInput);
        clientIdInput.sendKeys(String.valueOf(clientId));
        dateInput.sendKeys(date);
        payrollGroupInput.sendKeys(payrollGroup);
        startJobButton.click();
        return new SchedulerConsolePage(getWebDriver());
    }
}
