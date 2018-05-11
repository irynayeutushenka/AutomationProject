package mentoring.task2;

import mentoring.task2.ui.screens.SchedulerConsoleLoginPage;
import mentoring.task2.ui.screens.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayrollJobRunOnPayrollGroupLevelTest extends BaseTest {

    private String userName = "tomcat-jobs";
    private String password = "tomcat-jobs";

    private int clientId = 5003;
    private String date = "SYSDATE";
    private String payrollGroup = "US";

    private String successPayrollResult = "SUCCESS";


    @Test(description = "Successful run payroll job on payroll group level", priority = 2, dependsOnGroups = {"loginToSchedulerConsole"})
    public void successRunPayrollJobOnPayrollGroupLevel() {

        new SchedulerConsoleLoginPage(getWebDriver())
                .loginToSchedulerConsole(userName, password)
                .openPayrollJobSectionPage()
                .runPayrollJobOnPayrollGroupLevel(clientId, date, payrollGroup);

        SchedulerConsolePage schedulerConsolePage = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsolePage.getPayrollResultMessageText(), successPayrollResult,
                "Unexpected result of payroll job run");
    }
}
