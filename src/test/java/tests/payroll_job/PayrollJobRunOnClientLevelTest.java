package tests.payroll_job;

import business_objects.UserBO;
import business_objects.UserFactory;
import tests.common_test.BaseTest;
import page_objects.payroll_pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Logger;

import static business_objects.TestClients.CLIENT_5003;
import static service_classes.login_service.LoginService.loginToSchedulerConsole;

public class PayrollJobRunOnClientLevelTest extends BaseTest {

    private String date = "SYSDATE";
    private String successPayrollResult = "SUCCESS";

    UserBO schedulerConsoleUser = UserFactory.createSchedulerConsoleUser();

    @Test(description = "Successful run payroll job on client level", priority = 1,
            groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnClientLevel() {
        Logger.info("Log in to Scheduler Console");
        loginToSchedulerConsole(getWebDriver(), schedulerConsoleUser);
        Logger.info("Run Payroll job on client level");
        new SchedulerConsolePage(getWebDriver())
                .openPayrollJobSectionPage()
                .runPayrollJobOnClientLevel(CLIENT_5003.getId(), date);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Logger.info("Verify the result of job run");
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }
}
