package page_objects;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import utilities.DriverManager;

public abstract class BasePage {

    DriverManager driverManager;
    WebDriver webDriver;

    protected BasePage(WebDriver driver) {
        if (driver == null) {
            driver = driverManager.getInstance();
        }
        this.webDriver = driver;
        HtmlElementLoader.populatePageObject(this, this.webDriver);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
}
