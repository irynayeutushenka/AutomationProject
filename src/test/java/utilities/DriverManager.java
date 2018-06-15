package utilities;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver webDriver;

    protected abstract void createWebDriver();

    public WebDriver getInstance() {
        if (null == webDriver) {
            createWebDriver();
        }
        return webDriver;
    }
}
