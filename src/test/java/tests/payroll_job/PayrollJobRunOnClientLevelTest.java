package tests.payroll_job;

import business_objects.UserBO;
import business_objects.UserFactory;
import tests.common_test.BaseTest;
import page_objects.payroll_pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static business_objects.TestClients.CLIENT_5003;
import static service_classes.login_service.LoginService.loginToSchedulerConsole;

public class PayrollJobRunOnClientLevelTest extends BaseTest {

    private String date = "SYSDATE";
    private String successPayrollResult = "SUCCESS";

    UserBO schedulerConsoleUser = UserFactory.createSchedulerConsoleUser();

    @Test(description = "Successful run payroll job on client level", priority = 1,
            groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnClientLevel() {
        loginToSchedulerConsole(getWebDriver(), schedulerConsoleUser);
        new SchedulerConsolePage(getWebDriver())
                .openPayrollJobSectionPage()
                .runPayrollJobOnClientLevel(CLIENT_5003.getId(), date);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }
}
