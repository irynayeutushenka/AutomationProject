package mentoring.task2.ui.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayrollJobSectionPage extends Page {

    private By clientIdInput = By.name("client");
    private By dateInput = By.name("date");
    private By payrollGroupInput = By.name("payroll_group");
    private By startJobButton = By.id("start-job");

    public PayrollJobSectionPage(WebDriver driver) {
        super(driver);
    }

    public PayrollJobSectionPage typeClientId (int clientId){
        driver.findElement(clientIdInput).sendKeys(String.valueOf(clientId));
        return this;
    }

    public PayrollJobSectionPage typeDate (String date){
        driver.findElement(dateInput).sendKeys(date);
        return this;
    }

    public PayrollJobSectionPage typePayrollGroup (String payrollGroup){
        driver.findElement(payrollGroupInput).sendKeys(payrollGroup);
        return this;
    }

    public SchedulerConsolePage clickStartJobButton ( ){
        driver.findElement(startJobButton).click();
        return new SchedulerConsolePage(driver);
    }
}
