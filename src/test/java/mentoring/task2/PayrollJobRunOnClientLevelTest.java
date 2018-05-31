package mentoring.task2;

import mentoring.commonTest.BaseTest;
import mentoring.task2_PayrollJob.ui.pages.SchedulerConsoleLoginPage;
import mentoring.task2_PayrollJob.ui.pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayrollJobRunOnClientLevelTest extends BaseTest {

    private static final String URL =
            "https://staging-scheduler.corp.globoforce.com:8539/gf-scheduler-console/";
    private final String userName = "tomcat-jobs";
    private final String password = "tomcat-jobs";

    private int clientId = 5003;
    private String date = "SYSDATE";

    private String successPayrollResult = "SUCCESS";

    @Test(description = "Successful run payroll job on client level", priority = 1, groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnClientLevel() {

        new SchedulerConsoleLoginPage(getWebDriver())
                .loginToSchedulerConsole(userName, password)
                .openPayrollJobSectionPage()
                .runPayrollJobOnClientLevel(clientId, date);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }



}
