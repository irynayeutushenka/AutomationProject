package tests.payroll_job;

import business_objects.UserBO;
import business_objects.UserFactory;
import tests.common_test.BaseTest;
import page_objects.payroll_pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static business_objects.TestClients.CLIENT_5003;
import static service_classes.login_service.LoginService.loginToSchedulerConsole;

public class PayrollJobRunOnPayrollGroupLevelTest extends BaseTest {

    private String date = "SYSDATE";
    private String payrollGroup = "US";
    private String successPayrollResult = "SUCCESS";

    UserBO schedulerConsoleUser = UserFactory.createSchedulerConsoleUser();

    @Test(description = "Successful run payroll job on payroll group level", priority = 2,
            groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnPayrollGroupLevel() {
        loginToSchedulerConsole(getWebDriver(), schedulerConsoleUser);
        new SchedulerConsolePage(getWebDriver())
                .openPayrollJobSectionPage()
                .runPayrollJobOnPayrollGroupLevel(CLIENT_5003.getId(), date, payrollGroup);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }
}