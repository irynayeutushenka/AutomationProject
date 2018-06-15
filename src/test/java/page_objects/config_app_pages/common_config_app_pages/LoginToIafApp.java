package page_objects.config_app_pages.common_config_app_pages;

import business_objects.UserBO;
import page_objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
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

    public LoginToIafApp openLoginPage() {
        getWebDriver().get(URL);
        return new LoginToIafApp(getWebDriver());
    }

    public LoginToIafApp enterUserName(UserBO user) {
        loginInput.sendKeys(user.getUsername());
        return new LoginToIafApp(getWebDriver());
    }

    public LoginToIafApp enterPassword(UserBO user) {
        passwordInput.sendKeys(user.getPassword());
        return new LoginToIafApp(getWebDriver());
    }

    public IafHomePage clickSubmit() {
        loginButton.click();
        return new IafHomePage(getWebDriver());
    }
}