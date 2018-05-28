package pageObjects;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePage {

    protected final WebDriver webdriver;

    protected BasePage(WebDriver driver) {
        this.webdriver = driver;
        HtmlElementLoader.populatePageObject(this, this.webdriver);
    }

    public WebDriver getWebDriver() {
        return this.webdriver;
    }
}
