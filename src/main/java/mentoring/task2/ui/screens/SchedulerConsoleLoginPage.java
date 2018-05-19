package mentoring.task2.ui.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SchedulerConsoleLoginPage extends BasePage {

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

    public SchedulerConsoleLoginPage(WebDriver driver) {
        super(driver);
    }

    public SchedulerConsolePage loginToSchedulerConsole(String login, String password) {
        getWebDriver().get(URL);
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new SchedulerConsolePage(webdriver);
    }
}
