package mentoring.task2.ui.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SchedulerConsoleLoginPage extends Page {

    private By loginInput = By.name("j_username");
    private By passwordInput = By.name("j_password");
    private By submitButton = By.className("btn");
    private static final String URL =
            "https://staging-scheduler.corp.globoforce.com:8539/gf-scheduler-console/";

    public SchedulerConsoleLoginPage(WebDriver driver) {
        super(driver);
    }

    public SchedulerConsoleLoginPage openLoginPage() {
        driver.get(URL);
        return this;
    }

    public SchedulerConsoleLoginPage typeLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
        return this;
    }

    public SchedulerConsoleLoginPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public SchedulerConsolePage clickSubmit() {
        driver.findElement(submitButton).click();
        return new SchedulerConsolePage(driver);
    }
}
