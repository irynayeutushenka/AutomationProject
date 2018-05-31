package tests.payrollJob_task2;

import businessObjects.SchedulerConsoleUser;
import tests.commonTest.BaseTest;
import serviceClasses.loginService.LoginToSchedulerConsole;
import pageObjects.payrollPages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static businessObjects.TestClients.CLIENT_5003;

public class PayrollJobRunOnPayrollGroupLevelTest extends BaseTest {

    private String date = "SYSDATE";
    private String payrollGroup = "US";

    private String successPayrollResult = "SUCCESS";

    private SchedulerConsoleUser user = new SchedulerConsoleUser();

    @Test(description = "Successful run payroll job on payroll group level", priority = 2,
            groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnPayrollGroupLevel() {
        new LoginToSchedulerConsole(getWebDriver())
                .loginToSchedulerConsole(user)
                .openPayrollJobSectionPage()
                .runPayrollJobOnPayrollGroupLevel(CLIENT_5003.getId(), date, payrollGroup);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }
}