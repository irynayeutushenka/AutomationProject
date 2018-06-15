package tests.payroll_job;

import business_objects.UserBO;
import business_objects.UserFactory;
import tests.common_test.BaseTest;
import page_objects.payroll_pages.SchedulerConsolePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Logger;

import static service_classes.login_service.LoginService.loginToSchedulerConsole;

public class LoginToSchedulerConsoleTest extends BaseTest {

    private final String pageName = "Scheduler Console";

    UserBO schedulerConsoleUser = UserFactory.createSchedulerConsoleUser();

    @Test(description = "Successful login to Scheduler Console",
            groups = {"loginToSchedulerConsole", "payroll_test"})
    public void successLogin() {
        Logger.info("Log in to Scheduler Console");
        loginToSchedulerConsole(getWebDriver(), schedulerConsoleUser);
        SchedulerConsolePage schedulerConsoleScreen = new SchedulerConsolePage(getWebDriver());
        Logger.info("Verify the page name");
        Assert.assertEquals(schedulerConsoleScreen.getMainMenuLinkText(), pageName, "BasePage name is incorrect");
    }
}
