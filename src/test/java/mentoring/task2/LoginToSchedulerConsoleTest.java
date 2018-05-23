package mentoring.task2;

import mentoring.commonTest.BaseTest;
import mentoring.task2_PayrollJob.ui.pages.SchedulerConsoleLoginPage;
import mentoring.task2_PayrollJob.ui.pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToSchedulerConsoleTest extends BaseTest {

    private final String userName = "tomcat-jobs";
    private final String password = "tomcat-jobs";
    private final String pageName = "Scheduler Console";

    @Test(description = "Successful login to Scheduler Console", priority = 0, groups = {"loginToSchedulerConsole", "payroll_test"})
    public void successLogin() {

        new SchedulerConsoleLoginPage(getWebDriver())
                .loginToSchedulerConsole(userName, password);

        SchedulerConsolePage schedulerConsoleScreen = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsoleScreen.getMainMenuLinkText(), pageName, "BasePage name is incorrect");
    }
}
