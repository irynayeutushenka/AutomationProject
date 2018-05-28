package serviceClasses.loginService;

import businessObjects.SchedulerConsoleUser;
import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObjects.payrollPages.SchedulerConsolePage;
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

    public SchedulerConsolePage loginToSchedulerConsole(SchedulerConsoleUser user) {
        getWebDriver().get(URL);
        loginInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
        return new SchedulerConsolePage(webdriver);
    }
}
