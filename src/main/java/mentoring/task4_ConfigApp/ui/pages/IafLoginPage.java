package mentoring.task4_ConfigApp.ui.pages;

import mentoring.common.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class IafLoginPage extends BasePage {

    private static final String URL =
            "https://staging-sandbox0.corp.globoforce.com/iaf-login-app/home";

    @Name("Username input field")
    @FindBy(name = "j_username")
    private TextInput loginInput;

    @Name("Password input field")
    @FindBy(name = "j_password")
    private TextInput passwordInput;

    @Name("Login button")
    @FindBy(className = "button")
    private Button loginButton;

    public IafLoginPage(WebDriver driver) {
        super(driver);
    }

    public IafHomePage loginToIaf(String login, String password) {
        getWebDriver().get(URL);
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new IafHomePage(webdriver);
    }
}
