package tests.payrollJob_task2;

import businessObjects.SchedulerConsoleUser;
import tests.commonTest.BaseTest;
import serviceClasses.loginService.LoginToSchedulerConsole;
import pageObjects.payrollPages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static businessObjects.TestClients.CLIENT_5003;

public class PayrollJobRunOnClientLevelTest extends BaseTest {

    private static final String URL =
            "https://staging-scheduler.corp.globoforce.com:8539/gf-scheduler-console/";

    private String date = "SYSDATE";
    private String successPayrollResult = "SUCCESS";

    private SchedulerConsoleUser user = new SchedulerConsoleUser();

    @Test(description = "Successful run payroll job on client level", priority = 1,
            groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnClientLevel() {

        new LoginToSchedulerConsole(getWebDriver())
                .loginToSchedulerConsole(user)
                .openPayrollJobSectionPage()
                .runPayrollJobOnClientLevel(CLIENT_5003.getId(), date);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }
}
