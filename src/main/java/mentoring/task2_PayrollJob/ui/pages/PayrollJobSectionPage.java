package mentoring.task2_PayrollJob.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

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

    WebDriverWait wait = new WebDriverWait(getWebDriver(), 20); //here, wait time is 20 seconds

    public SchedulerConsolePage runPayrollJobOnClientLevel(int clientId, String date) {
        wait.until(ExpectedConditions.visibilityOf(clientIdInput)); //this will wait for element to be visible for 20 seconds*/
        clientIdInput.sendKeys(String.valueOf(clientId));
        dateInput.sendKeys(date);
        startJobButton.click();
        return new SchedulerConsolePage(getWebDriver());
    }

    public SchedulerConsolePage runPayrollJobOnPayrollGroupLevel(int clientId, String date, String payrollGroup) {
        wait.until(ExpectedConditions.visibilityOf(clientIdInput)); //this will wait for element to be visible for 20 seconds
        clientIdInput.sendKeys(String.valueOf(clientId));
        dateInput.sendKeys(date);
        payrollGroupInput.sendKeys(payrollGroup);
        startJobButton.click();
        return new SchedulerConsolePage(getWebDriver());
    }
}
