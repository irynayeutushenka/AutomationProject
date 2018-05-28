package tests.payrollJob_task2;

import businessObjects.SchedulerConsoleUser;
import tests.commonTest.BaseTest;
import serviceClasses.loginService.LoginToSchedulerConsole;
import pageObjects.payrollPages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToSchedulerConsoleTest extends BaseTest {

    private final String pageName = "Scheduler Console";

    private SchedulerConsoleUser user = new SchedulerConsoleUser();

    @Test(description = "Successful login to Scheduler Console", priority = 0,
            groups = {"loginToSchedulerConsole", "payroll_test"})
    public void successLogin() {
        new LoginToSchedulerConsole(getWebDriver())
                .loginToSchedulerConsole(user);

        SchedulerConsolePage schedulerConsoleScreen = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsoleScreen.getMainMenuLinkText(), pageName, "BasePage name is incorrect");
    }
}
