package serviceClasses.loginService;

import businessObjects.IafConsoleUser;
import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObjects.configAppPages.CommonConfigAppPages.IafHomePage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginToIafApp extends BasePage {

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

    public LoginToIafApp(WebDriver driver) {
        super(driver);
    }

    public IafHomePage loginToIaf(IafConsoleUser user) {
        getWebDriver().get(URL);
        loginInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        return new IafHomePage(webdriver);
    }
}
