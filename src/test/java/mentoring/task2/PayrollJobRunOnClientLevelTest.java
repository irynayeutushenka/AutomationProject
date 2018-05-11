package mentoring.task2;

import mentoring.task2.ui.screens.SchedulerConsoleLoginPage;
import mentoring.task2.ui.screens.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayrollJobRunOnClientLevelTest extends BaseTest {

    private static final String URL =
            "https://staging-scheduler.corp.globoforce.com:8539/gf-scheduler-console/";
    private String userName = "tomcat-jobs";
    private String password = "tomcat-jobs";

    private int clientId = 5003;
    private String date = "SYSDATE";

    private String successPayrollResult = "SUCCESS";

    @Test(description = "Successful run payroll job on client level", priority = 1, dependsOnGroups = {"loginToSchedulerConsole"})
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
