package tests.payroll_job;

import business_objects.UserBO;
import business_objects.UserFactory;
import tests.common_test.BaseTest;
import page_objects.payroll_pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static service_classes.login_service.LoginService.loginToSchedulerConsole;

public class LoginToSchedulerConsoleTest extends BaseTest {

    private final String pageName = "Scheduler Console";

    UserBO schedulerConsoleUser = UserFactory.createSchedulerConsoleUser();

    @Test(description = "Successful login to Scheduler Console", priority = 0,
            groups = {"loginToSchedulerConsole", "payroll_test"})
    public void successLogin() {
        loginToSchedulerConsole(getWebDriver(), schedulerConsoleUser);
        SchedulerConsolePage schedulerConsoleScreen = new SchedulerConsolePage(getWebDriver());
        Assert.assertEquals(schedulerConsoleScreen.getMainMenuLinkText(), pageName, "BasePage name is incorrect");
    }
}
