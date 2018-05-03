package mentoring.task2.ui.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SchedulerConsolePage extends Page{

    private By mainMenuLink = By.cssSelector("a[href='/gf-scheduler-console/']");
    private By payrollRunButton = By.xpath
            ("//a[(text()='Globoforce--Payroll Job Manual')]/../following-sibling::td/button[text()=\"Run\"]");
    private By payrollResultMessage = By.xpath
            ("//a[(text()='Globoforce--Payroll Job Manual')]/../following-sibling::td/a");

    public SchedulerConsolePage(WebDriver driver) {
        super(driver);
    }

    public String getMainMenuLinkText() {
        return driver.findElement(mainMenuLink).getText();
    }

    public PayrollJobSectionPage clickPayrollRunButton() {
        driver.findElement(payrollRunButton).click();
        return new PayrollJobSectionPage(driver);
    }

    public String getPayrollResultMessageText() {
        return driver.findElement(payrollResultMessage).getText();
    }
}
