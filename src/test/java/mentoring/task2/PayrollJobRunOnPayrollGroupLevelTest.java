package mentoring.task2;

import mentoring.commonTest.BaseTest;
import mentoring.task2_PayrollJob.ui.pages.SchedulerConsoleLoginPage;
import mentoring.task2_PayrollJob.ui.pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayrollJobRunOnPayrollGroupLevelTest extends BaseTest {

    private final String userName = "tomcat-jobs";
    private final String password = "tomcat-jobs";

    private int clientId = 5003;
    private String date = "SYSDATE";
    private String payrollGroup = "US";

    private String successPayrollResult = "SUCCESS";


    @Test(description = "Successful run payroll job on payroll group level", priority = 2, groups = "payroll_test", dependsOnGroups = {"loginToSchedulerConsole"})
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
