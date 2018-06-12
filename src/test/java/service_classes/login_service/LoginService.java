package service_classes.login_service;

import business_objects.UserBO;

import org.openqa.selenium.WebDriver;
import page_objects.config_app_pages.common_config_app_pages.LoginToIafApp;
import page_objects.payroll_pages.LoginToSchedulerConsole;

public class LoginService {

    public static void loginToSchedulerConsole(WebDriver driver, UserBO user) {
        new LoginToSchedulerConsole(driver)
                .openLoginPage()
                .enterUserName(user)
                .enterPassword(user)
                .clickSubmit();
    }

    public static void loginToIaf(WebDriver driver, UserBO user) {
        new LoginToIafApp(driver)
                .openLoginPage()
                .enterUserName(user)
                .enterPassword(user)
                .clickSubmit();
    }
}
