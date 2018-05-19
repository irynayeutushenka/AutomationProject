package mentoring.task2;

import mentoring.task2.ui.screens.SchedulerConsoleLoginPage;
import mentoring.task2.ui.screens.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToSchedulerConsoleTest extends BaseTest {

    private String userName = "tomcat-jobs";
    private String password = "tomcat-jobs";
    private String pageName = "Scheduler Console";

    @Test(description = "Successful loginToSchedulerConsole to Scheduler Console", priority = 0, groups = {"loginToSchedulerConsole", "payroll_test"})
    public void successLogin() {

        new SchedulerConsoleLoginPage(getWebDriver())
                .loginToSchedulerConsole(userName, password);

        SchedulerConsolePage schedulerConsoleScreen = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsoleScreen.getMainMenuLinkText(), pageName, "BasePage name is incorrect");
    }
}
