package page_objects.payroll_pages;

import business_objects.UserBO;
import page_objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginToSchedulerConsole extends BasePage {

    private static final String URL =
            "https://staging-scheduler.corp.globoforce.com:8539/gf-scheduler-console/";
    /*"https://preprod-scheduler.corp.globoforce.com:8539/gf-scheduler-console/";*/

    @Name("Login input field")
    @FindBy(name = "j_username")
    private TextInput loginInput;

    @Name("Password input field")
    @FindBy(name = "j_password")
    private TextInput passwordInput;

    @Name("Submit button")
    @FindBy(className = "btn")
    private Button submitButton;

    public LoginToSchedulerConsole(WebDriver driver) {
        super(driver);
    }

    public LoginToSchedulerConsole openLoginPage() {
        getWebDriver().get(URL);
        return new LoginToSchedulerConsole(getWebDriver());
    }

    public LoginToSchedulerConsole enterUserName(UserBO user) {
        loginInput.sendKeys(user.getUsername());
        return new LoginToSchedulerConsole(getWebDriver());
    }

    public LoginToSchedulerConsole enterPassword(UserBO user) {
        passwordInput.sendKeys(user.getPassword());
        return new LoginToSchedulerConsole(getWebDriver());
    }

    public SchedulerConsolePage clickSubmit() {
        submitButton.click();
        return new SchedulerConsolePage(getWebDriver());
    }
}
